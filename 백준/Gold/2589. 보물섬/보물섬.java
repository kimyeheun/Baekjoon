import java.io.*;
import java.util.*;

public class Main {
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int M;

    static int[][] map_original;

    public static int bfs(int n, int m) {
        int[][]  map = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, m});
        visit[n][m] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.remove();

            for(int[] mm : move) {
                int next_n = mm[0] + now[0];
                int next_m = mm[1] + now[1];

                if (next_n >= N || next_n < 0 || next_m >= M || next_m < 0)
                    continue;
                if (visit[next_n][next_m] || map_original[next_n][next_m] == -1)
                    continue;

                queue.add(new int[]{next_n, next_m});
                visit[next_n][next_m] = true;
                map[next_n][next_m] = map[now[0]][now[1]] + 1;
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (max < map[i][j])
                    max = map[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map_original = new int[N][M];

        for(int n =0; n < N; n++) {
            int m = 0;
            String line = br.readLine();
            for(int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'W') map_original[n][m++] = -1;
                else map_original[n][m++] = 0;
            }
        }

        int result = 0;

        // L인 곳 모두 탐색
        for(int n = 0; n < N; n++) {
            for(int m = 0; m < M; m++) {
                if (map_original[n][m] == 0) {
                    result = Math.max(bfs(n, m), result);
                }
            }
        }
        System.out.println(result);
    }
}
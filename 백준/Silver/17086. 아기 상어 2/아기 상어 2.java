import java.io.*;
import java.util.*;


public class Main {
    static int[][] move = {{-1, 0}, {1, 0}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
                if(map[n][m] == 1) {
                    map[n][m] = 0;
                    queue.add(new int[]{n, m});
                    visited[n][m] = true;
                }
            }
        }

        int result = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int[] mv : move) {
                int nextn = now[0] + mv[0];
                int nextm = now[1] + mv[1];

                if (nextn < 0 || nextm < 0 || nextn >= N || nextm >= M) continue;
                if (visited[nextn][nextm]) continue;

                map[nextn][nextm] = map[now[0]][now[1]] + 1;
                visited[nextn][nextm] = true;
                result = Math.max(result, map[nextn][nextm]);
                queue.add(new int[]{nextn, nextm});
            }
        }

        System.out.println(result);
    }
}

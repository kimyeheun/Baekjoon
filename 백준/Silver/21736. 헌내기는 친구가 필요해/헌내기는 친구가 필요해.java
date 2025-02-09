import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int M;
    static char[][] map;
    static int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static boolean[][] visited;
    static int result = 0;

    static void dfs(int n, int m) {
        if(visited[n][m]) return;

        visited[n][m] = true;
        if (map[n][m] == 'P') result++;

        for(int[] mv : move) {
            int nextn = n + mv[0];
            int nextm = m + mv[1];

            if (nextn < 0 || nextn >= N || nextm < 0 || nextm >= M) continue;
            if (map[nextn][nextm] == 'X') continue;
            dfs(nextn, nextm);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        int s = 0;
        int e = 0;
        for(int n = 0; n < N; n++) {
            String line = br.readLine();
            for(int m = 0; m < M; m++) {
                map[n][m] = line.charAt(m);
                if (map[n][m] == 'I') {
                    s = n;
                    e = m;
                }
            }
        }

        dfs(s, e);

        if (result == 0) System.out.println("TT");
        else System.out.println(result);

    }
}

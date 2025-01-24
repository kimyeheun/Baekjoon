import java.io.*;
import java.util.*;


public class Main {
    static class XY{
        int n;
        int m;
        int day;

        XY(int n, int m, int day) {
            this.n = n;
            this.m = m;
            this.day = day;
        }
    }

    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        int x = -1, y = -1;
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                box[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<XY> queue = new LinkedList<>();

        for(int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (box[n][m] == 1) {
                    queue.add(new XY(n, m, 0));
                    visit[n][m] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            XY now = queue.remove();

            for (int[] mm : move) {
                int next_n = now.n + mm[0];
                int next_m = now.m + mm[1];

                if (next_n >= N || next_n < 0 || next_m >= M || next_m < 0) continue;
                if (visit[next_n][next_m]) continue;
                if (box[next_n][next_m] >= 0) {
                    queue.add(new XY(next_n, next_m, ++now.day));
                    box[next_n][next_m] = box[now.n][now.m] + 1;
                    visit[next_n][next_m] = true;
                }
            }
        }

        int result = 0;
        for(int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (box[n][m] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, box[n][m]);
            }
        }
        System.out.println(result - 1);
    }
}

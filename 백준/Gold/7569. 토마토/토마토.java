import java.io.*;
import java.util.*;


public class Main {
    static int[][] move = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    static class Tomato {
        int m;
        int n;
        int h;

        public Tomato(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] box = new int[H][N][M];
        boolean[][][] visit = new boolean[H][N][M];

        Queue<Tomato> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == -1) visit[h][n][m] = true;
                    else if (box[h][n][m] == 1) {
                        queue.add(new Tomato(h, n, m));
                        visit[h][n][m] = true;
                    }
                    else if (box[h][n][m] == -1)
                        visit[h][n][m] = true;
                }
            }
        }

        int day = 0;
        while(!queue.isEmpty()) {
            int per_day = queue.size();
            for (int i = 0; i < per_day; i++) {
                Tomato now = queue.remove();
                int nowh = now.h;
                int nown = now.n;
                int nowm = now.m;

                for (int[] m : move) {
                    int nexth = nowh + m[0];
                    int nextn = nown + m[1];
                    int nextm = nowm + m[2];

                    if (nexth >= H || nexth < 0 || nextn >= N || nextn < 0 || nextm >= M || nextm < 0) continue;

                    if (box[nexth][nextn][nextm] == -1) continue;
                    else if (box[nexth][nextn][nextm] == 0 && !visit[nexth][nextn][nextm]) {
                        visit[nexth][nextn][nextm] = true;
                        queue.add(new Tomato(nexth, nextn, nextm));
                    }
                }
            }
            day++;
        }

        int result = day-1;
        for(int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if(!visit[h][n][m]) result = -1;
                }
            }
        }
        System.out.println(result);
    }
}

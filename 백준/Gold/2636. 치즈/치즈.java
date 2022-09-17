import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int ans_cheese = 0;
    static int ans_time = 0;

    static int[][] cheese;
    static boolean[][] visit;
    static int[] move_x = {1, 0, -1, 0};
    static int[] move_y = {0, 1, 0, -1};

    static Queue<int[]> air = new LinkedList<>();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        StringTokenizer st = new StringTokenizer(buf);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        air.add(new int[]{0, 0});

        int ans = 0, ans2=0;
        while(!air.isEmpty()) {
            ans = ans_cheese;
            ans2 = ans_time;
            visit = new boolean[N][M];
            out_air(air.peek()[0], air.peek()[1]);
            melt();
            ans_time++;
        }

        System.out.println(ans2);
        System.out.println(ans);
    }

    public static void out_air(int now_x, int now_y) {
        for (int i = 0; i < 4; i++) {
            int next_x = now_x + move_x[i];
            int next_y = now_y + move_y[i];

            if (next_x >= 0 && next_y >= 0 && next_x < N && next_y < M) {
                if (!visit[next_x][next_y] && cheese[next_x][next_y] == 0) {
                    air.add(new int[]{next_x, next_y});
                    visit[next_x][next_y] = true;
                    out_air(next_x, next_y);
                }
            }
        }
    }

    public static void melt() {
        ans_cheese = 0;
        int size = air.size();
        for (int i = 0; i < size; i++) {
            int now_x = air.peek()[0];
            int now_y = air.poll()[1];
            for (int a = 0; a < 4; a++) {

                int next_x = now_x + move_x[a];
                int next_y = now_y + move_y[a];

                if (next_x >= 0 && next_y >= 0 && next_x < N && next_y < M) {
                    if (!visit[next_x][next_y] && cheese[next_x][next_y] == 1) {
                        air.add(new int[]{next_x, next_y});
                        cheese[next_x][next_y] = 0;
                        ans_cheese++;
                    }
                }
            }
        }
    }
}

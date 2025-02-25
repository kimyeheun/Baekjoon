import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] player;
    static int maxScore = 0;

    static int play(int[] order) {
        int score = 0;
        int hitterIndex = 0; 

        for (int inning = 0; inning < N; inning++) {
            int outCount = 0;
            boolean[] base = new boolean[4]; // 루 상태 (1~3루)

            while (outCount < 3) {
                int hitter = order[hitterIndex];
                int now = player[inning][hitter];

                if (now == 0) outCount++;
                else {
                    for (int i = 3; i >= 1; i--) {
                        if (base[i]) {
                            int nextBase = i + now;
                            if (nextBase >= 4) score++;
                            else base[nextBase] = true;
                            base[i] = false;
                        }
                    }
                    // 타자 이동
                    if (now == 4) score++;
                    else base[now] = true;
                }
                hitterIndex = (hitterIndex + 1) % 9;
            }
        }
        return score;
    }

    static void backTracking(int cnt, boolean[] visited, int[] order) {
        if (cnt == 9) {
            maxScore = Math.max(maxScore, play(order));
            return;
        }

        if (cnt == 3) {
            order[3] = 0;
            backTracking(cnt + 1, visited, order);
        }
        else {
            for (int i = 1; i < 9; i++) {
                if (!visited[i]) {
                    order[cnt] = i;
                    visited[i] = true;
                    backTracking(cnt + 1, visited, order);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        player = new int[N][9];
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                player[n][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] order = new int[9]; 
        boolean[] visited = new boolean[9];
        visited[0] = true; 
        backTracking(0, visited, order);

        System.out.println(maxScore);
    }
}

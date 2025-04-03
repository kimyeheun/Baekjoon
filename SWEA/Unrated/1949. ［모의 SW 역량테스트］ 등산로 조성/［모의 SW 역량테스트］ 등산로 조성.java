import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N;
    static int K;
    static int[][] map;
    static int[][] dp;

    static int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    static int result;

    static int findLongestPath(int n, int m) {
        if (dp[n][m] != -1) return dp[n][m];

        int maxPath = 1;
        for (int[] mv : move) {
            int nextn = n + mv[0];
            int nextm = m + mv[1];

            if (nextn < 0 || nextm < 0 || nextn >= N || nextm >= N) continue;
            if (map[nextn][nextm] >= map[n][m]) continue; // 내리막길
            maxPath = Math.max(maxPath, 1 + findLongestPath(nextn, nextm));
        }

        return dp[n][m] = maxPath;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            dp = new int[N][N];
            int max = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    max = Math.max(max, map[i][j]);
                    dp[i][j] = -1;
                }
            }

            result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) {
                        result = Math.max(result, findLongestPath(i, j));
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int originH = map[i][j];
                    for (int k = 1; k <= K; k++) {
                        map[i][j] -= k;

                        // dp 초기화
                        dp = new int[N][N];
                        for (int x = 0; x < N; x++) Arrays.fill(dp[x], -1);

                        for (int x = 0; x < N; x++) {
                            for (int y = 0; y < N; y++) {
                                if (map[x][y] == max) {
                                    result = Math.max(result, findLongestPath(x, y));
                                }
                            }
                        }
                        map[i][j] = originH; // 원복
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] game = new int[n][n];
        long[][] dp = new long[n][n];

        for(int i = 0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 0;
            }
        }

        dp[0][0] = 1;
        int buf;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n-1 && j == n-1) break;
                if (game[i][j] == 0) continue;
                if (dp[i][j] != 0) {
                    buf = game[i][j];
                    if (j + buf < n) dp[i][j + buf] += dp[i][j];
                    if (i + buf < n) dp[i + buf][j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
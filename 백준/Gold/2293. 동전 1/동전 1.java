import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n  = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        int[] dp = new int[k+1];
        for (int i = 0; i <= k; i++) {
            if (coins[0] * i > k) break;
            dp[coins[0] * i] = 1;
        }

        for (int c = 1; c < n; c++) {
            for (int i = coins[c]; i <= k; i++) {
                dp[i] += dp[i - coins[c]];
            }
        }

        System.out.println(dp[k]);
    }
}
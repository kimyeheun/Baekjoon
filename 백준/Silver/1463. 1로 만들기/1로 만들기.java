import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[1] = 0;
        if (N >= 2)
            dp[2] = 1;
        if (N >= 3) {
            dp[3] = 1;
            for(int n = 4; n <= N; n++) {
                if (n % 3 == 0)
                    dp[n] = Math.min(dp[n/3] + 1, dp[n-1] + 1);
                else if (n % 2 == 0)
                    dp[n] = Math.min(dp[n/2] + 1, dp[n-1] + 1);
                else dp[n] = dp[n - 1] + 1;

                if (n % 6 == 0)
                    dp[n] = Math.min(dp[n/3] + 1, Math.min(dp[n-1] + 1, dp[n/2] + 1));
            }
        }
        System.out.println(dp[N]);
    }
}

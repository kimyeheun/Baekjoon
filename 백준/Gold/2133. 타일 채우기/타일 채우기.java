import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];

        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }
        dp[2] = 3;
        if (N >= 4)
            dp[4] = 11;

        for (int n = 6; n <= N; n+= 2) {
            dp[n] = 3 * dp[n - 2];
            for (int j = n - 4; j >= 0; j -= 2) {
                dp[n] += 2 * dp[j]; // 추가 패턴을 고려
            }
            dp[n] += 2;
        }

        System.out.println(dp[N]);
    }
}

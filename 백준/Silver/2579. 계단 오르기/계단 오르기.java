import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] step = new int[N];
        int[] dp = new int[N];

        // dp[i] = Math.max(dp[i-3] + step[i] + step[i-1], dp[i-2] + step[i])

        for (int i = 0; i < N; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = step[0];
        if (N > 1) {
            dp[1] = Math.max(dp[0] + step[1], step[1]);
            if (N > 2) {
                dp[2] = Math.max(dp[0] + step[2], step[1] + step[2]);
                for (int i = 3; i < N; i++) {
                    dp[i] = Math.max(dp[i - 3] + step[i - 1] + step[i], dp[i - 2] + step[i]);
                }
            }
        }

        System.out.println(dp[N-1]);
    }
}
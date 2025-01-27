import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N+1];
            dp[0] = 1;
            if (N >= 1) dp[1] = 1;
            if (N >= 2) {
                dp[2] = 2;
                for(int i = 3; i <= N; i++) {
                    dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
                }
            }
            System.out.println(dp[N]);
        }
    }
}

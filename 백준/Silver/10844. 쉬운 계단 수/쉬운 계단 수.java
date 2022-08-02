import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final long MOD = 1_000_000_000L;
    
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        long[][] dp = new long[N+1][10];

        dp[1][0] = 0L;
        for(int i=1; i<10; i++) {
            dp[1][i] = 1L;
        }

        for(int i=2; i<=N; i++) {
            dp[i][0] = dp[i-1][1];
            for(int j=1; j<=9; j++) {
                if(j == 9) {
                    dp[i][9] = dp[i-1][8] % MOD;
                }
                else
                    dp[i][j] = (dp[i-1][j-1] % MOD + dp[i-1][j+1] % MOD) % MOD;
            }
        }

        long result = 0;
        
        for(int i=0; i<10; i++) {
            result = (result + dp[N][i]) % MOD;   
        }
        System.out.print(result);
    }
}

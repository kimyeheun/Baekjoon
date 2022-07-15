import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        long[] dp = new long[t+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= t; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[t]);
    }
}

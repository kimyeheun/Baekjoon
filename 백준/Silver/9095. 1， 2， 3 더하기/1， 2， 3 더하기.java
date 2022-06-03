import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] dp = new Integer[12];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for(int i = 3; i < 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int test = sc.nextInt();
        
        for(int o = 0; o < test; o++) {
            int t = sc.nextInt();
            System.out.println(dp[t-1]);
        }
    }
}
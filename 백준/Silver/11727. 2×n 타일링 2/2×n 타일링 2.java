import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(sc.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i <= test; i++) {
            dp[i] = (dp[i-1] + dp[i-2] *2)%10007;
        }
        System.out.println(dp[test]);
    }
}
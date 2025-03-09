import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] dp;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for(int idx = 0; idx < i; idx++) {
                if(nums[idx] < nums[i])
                    dp[i] = Math.max(dp[i], dp[idx] + 1);
            }
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}

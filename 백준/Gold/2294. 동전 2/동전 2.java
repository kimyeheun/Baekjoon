import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[N];
        
        int[] dp = new int[K + 1]; 
        for (int k = 0; k <= K; k++) {
        	dp[k] = Integer.MAX_VALUE - 1;
        }
        
        dp[0] = 0;
        
        for(int n = 0; n < N; n++) {
        	coins[n] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(coins);
        
        for (int c : coins) {
	        for (int i = c; i <= K; i++) {
	        	dp[i] = Math.min(dp[i], dp[i - c] + 1);		
	        }
        }
        
        if(dp[K] == Integer.MAX_VALUE - 1)
        	System.out.println(-1);
        else
	        System.out.println(dp[K]);
    }
}

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t=0; t < T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	long[] dp = new long[Math.max(N, 5)];
        	dp[0] = 1;
        	dp[1] = 1;
        	dp[2] = 1;
        	dp[3] = 2;
        	dp[4] = 2;
        	
        	for (int i = 5; i < N; i++) {
        		dp[i] = dp[i-1] + dp[i-5];
        	}
        	
        	bw.append(dp[N-1] + "\n");
        }
                
        bw.flush();
        bw.close();
    }
}

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            for(int nowMaxW = K; nowMaxW >= w; nowMaxW--) 
                dp[nowMaxW] = Math.max(dp[nowMaxW], dp[nowMaxW - w] + v);
        }
        System.out.println(dp[K]);
    }
}
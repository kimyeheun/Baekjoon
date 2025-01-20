import java.io.*;
import java.util.*;


public class Main {
	static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

	static int N, M;
	static int[][] map;
	static int[][] dp;
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        
        // 맵 초기화 
        map = new int[N][M];
        dp = new int[N][M];
        
        for (int n =0; n<N; n++) {
        	st = new StringTokenizer(br.readLine());
        	for (int m = 0; m < M; m++) {
        		map[n][m] = Integer.parseInt(st.nextToken());
        		Arrays.fill(dp[n], -1);
        	}
        }
                 
        System.out.println(dfs(0, 0));
    }
    
    public static int dfs(int n, int m) {
        int next_n, next_m;
        
        // 목표 지점
        if (n == N-1 && m == M-1) {
    		dp[n][m]++;
			return 1;
		}
        
        // 이미 계산한 노드
    	if (dp[n][m] != -1) { 
    		return dp[n][m];
    	}
    	
		dp[n][m] = 0;

		for(int[] mo : move) {
			next_n = n + mo[0];
			next_m = m + mo[1];
			
    		// 범위 체크
    		if(next_n >= N || next_m >= M || next_n < 0 || next_m < 0)
    			continue;
    	
    		// 높이 체크 
    		if(map[next_n][next_m] >= map[n][m]) {
    			continue;
    		}

    		dp[n][m] += dfs(next_n, next_m);
		}
	    		
    	return dp[n][m];
    }
}

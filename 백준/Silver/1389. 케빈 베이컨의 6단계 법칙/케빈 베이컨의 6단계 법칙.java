import java.io.*;
import java.util.*;


// 플로이드-워셜 알고리즘 
// == 모든 최단 경로를 구하는 알고리즘
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] friends = new int[N+1][N+1];
        for(int n = 1; n <= N; n++) {
        	Arrays.fill(friends[n], Integer.MAX_VALUE);
        	friends[n][n] = 0;
        }
        for(int m = 0; m < M; m++) {
        	st = new StringTokenizer(br.readLine());
        	int n1 = Integer.parseInt(st.nextToken());
        	int n2 = Integer.parseInt(st.nextToken());
        	friends[n1][n2] = 1;
        	friends[n2][n1] = 1;
        }
        
        for(int i = 1; i <= N; i ++) {
    	    for(int n = 1; n <= N; n++) { 
        		for(int m = 1; m <= N; m++) {
        			if (friends[n][i] == Integer.MAX_VALUE || friends[i][m] == Integer.MAX_VALUE) continue;
        			friends[n][m] = Math.min(friends[n][m], friends[n][i] + friends[i][m]);
        		}
        	}
        }
        
        int result = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = N; i >= 1; i --) {
        	int sum = 0;
        	
        	for(int j = 1; j <= N; j++) 
        		sum += friends[i][j];
        	
        	if (result >= sum) {
        		idx = i;
        		result = sum;
        	}
        }
        
        System.out.println(idx);
    }
}

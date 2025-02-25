import java.io.*;
import java.util.*;


public class Solution {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 누적합 
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i== 0 && j == 0) continue;
					else if (i == 0) map[i][j] += map[i][j-1];
					else if (j == 0) map[i][j] += map[i-1][j];
					else map[i][j] += map[i-1][j] + map[i][j-1] - map[i-1][j-1]; 
				}
			}
			
			int max = 0;
            int buf;
			for(int i = M-1; i < N; i++) {
				for(int j = M-1; j < N; j++) {
					if(i == M-1 && j == M-1) buf = map[i][j];
					else if (i == M-1) buf = map[i][j] - map[i][j-M];
					else if (j == M-1) buf = map[i][j] - map[i-M][j];
					else buf = map[i][j] - map[i-M][j] - map[i][j-M] + map[i-M][j-M];
					max = Math.max(max, buf);
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}

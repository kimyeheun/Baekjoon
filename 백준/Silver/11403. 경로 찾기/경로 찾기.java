import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[][] result = new int[N][N];
    
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		int now = Integer.parseInt(st.nextToken());
        		if (now == 1)
	        		map[i][j] = 1;
        		else map[i][j] = Integer.MAX_VALUE;
        	}
        	map[i][i] = 0;
        }
        
        // 좌표 순회 
        for(int i = 0; i < N; i++) {
        	for(int x = 0; x < N; x++) {
        		for(int y = 0; y < N; y++) {
        			if (map[x][i] + map[i][y] == 2)
        				map[x][y] = 1;
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
	        	if(map[i][j] == 1) sb.append(1).append(" ");
	        	else sb.append(0).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}

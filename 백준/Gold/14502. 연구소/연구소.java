import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int M;
	static int[][] map;
	
	static List<int[]> zeroSection;
	// 전체 0의 개수 
	static int zeroNum; 
	static int[][] move = {{0,1}, {1,0}, {-1,0}, {0,-1}};
	// 안전 영역 (최대)
	static int result = 0;
	static StringBuilder sb = new StringBuilder();
	
	
	static int calcSafe(int[][] map) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if (map[n][m] == 2) queue.add(new int[] {n, m});
			}
		}
		
		int visitedZero = 0; // 안전하지 않은 0의 개수 
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int[] mv : move) {
				int nextn = now[0] + mv[0];
				int nextm = now[1] + mv[1];
				
				if (nextn < 0 || nextm < 0 || nextn >= N || nextm >= M) continue;
				if (map[nextn][nextm] != 0) continue;
				if (visited[nextn][nextm]) continue;
				
				queue.add(new int[] {nextn, nextm});
				visited[nextn][nextm] = true;
				visitedZero++;
			}
			if (zeroNum - visitedZero <= result) return -1;
		}
		
		// 안전 영역 반환 
		return zeroNum - visitedZero;
	}
	
	static void constructWall(int idx, int wall, boolean[] visited) {
		if (wall == 3) {
			// 가벽을 세움 
			for(int i = 0; i < zeroNum; i++) {
				if (visited[i]) {
					int[] nowWall = zeroSection.get(i);
					map[nowWall[0]][nowWall[1]] = 1;
				}
			}
		   
			int bufResult = calcSafe(map);
			if (result < bufResult) result = bufResult;
			
			// 가벽을 부숨 
			for(int i = 0; i < zeroNum; i++) {
				if (visited[i]) {
					int[] nowWall = zeroSection.get(i);
					map[nowWall[0]][nowWall[1]] = 0;
				}
			}
			return;
		}
		if (idx >= zeroNum) return;
		
		// 현재 위치를 포함 하지 않음
		constructWall(idx+1, wall, visited);
		// 현재 위치를 포함함 
		if (!visited[idx]) {
			visited[idx] = true;
			constructWall(idx+1, wall+1, visited);
			visited[idx] = false;
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	zeroSection = new ArrayList<>();
    	map = new int[N][M];
    	
    	for(int n = 0; n < N; n++) {
    		st = new StringTokenizer(br.readLine());
    		for(int m = 0; m < M; m++) {
    			map[n][m] = Integer.parseInt(st.nextToken());
    			if (map[n][m] == 0) zeroSection.add(new int[] {n, m});
    		}
    	}
    	
    	zeroNum = zeroSection.size();
    	boolean[] visited = new boolean[zeroNum];
    	
    	constructWall(0, 0, visited);
    	System.out.println(result - 3);
    }
}


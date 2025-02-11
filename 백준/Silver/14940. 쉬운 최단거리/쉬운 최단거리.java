import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	static void bfs(int i, int j, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		map[i][j] = 0;
		
		while(!queue.isEmpty()) {
			int[] now = queue.remove();
			for(int[] m : move) {
				int nexti = now[0] + m[0];
				int nextj = now[1] + m[1];

				if (nexti < 0 || nextj < 0 || nexti >= N || nextj >= M) continue;
				if (visited[nexti][nextj] || map[nexti][nextj] != -1) continue;
				
				visited[nexti][nextj] = true;
				map[nexti][nextj] = map[now[0]][now[1]] + 1;
				queue.add(new int[] {nexti, nextj});
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] start = new int[2];
        
        for(int i = 0; i <N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		int now = Integer.parseInt(st.nextToken());
        		if (now == 2) {
        			start[0] = i;
        			start[1] = j;
        		}
        		map[i][j] = now == 1 ? -1 : now;
        	}
        }
        bfs(start[0], start[1], visited);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <N; i++) {
        	for(int j = 0; j < M; j++) {
        		sb.append(map[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}

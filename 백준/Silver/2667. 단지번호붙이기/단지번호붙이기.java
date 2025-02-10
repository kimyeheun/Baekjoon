import java.io.*;
import java.util.*;


public class Main {
	static int[][] move = {{0,1}, {0,-1}, {-1,0}, {1,0}};
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int bfs(int n, int m) {
		int result = 0;
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] {n,m});
		visited[n][m] = true;

		while(!stack.isEmpty()) {
			int[] now = stack.pop();
			result++;

			for(int[] mv : move) {
				int nextn = now[0] + mv[0];
				int nextm = now[1] + mv[1];
				
				if(nextn < 0 || nextn >= N || nextm < 0 || nextm >= N) continue;
				if (!visited[nextn][nextm] && map[nextn][nextm] == 1) {
					stack.add(new int[] {nextn, nextm});
					visited[nextn][nextm] = true;
				}
			}
		}
		
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		List<Integer> list = new ArrayList<>();
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					list.add(bfs(i, j));
					result ++;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(result);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

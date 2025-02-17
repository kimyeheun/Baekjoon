import java.io.*;
import java.util.*;


public class Main {
	static int[][] move = {{-1,0}, {1,0}, {0,1}, {0,-1}, {0, 0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		Stack<int[]> bomb = new Stack<>();
		
		for(int n = 0; n < N; n++) {
			String line = br.readLine();
			for(int m = 0; m < M; m++) {
				map[n][m] = line.charAt(m);
				if(map[n][m] == 'O') bomb.add(new int[] {n, m});
			}
		}
		
		StringBuilder sb = new StringBuilder();
		// 시간이 1초일 때는 map 그대로를 출력 
		if (T == 1) {
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					sb.append(map[n][m]);
				}
				sb.append("\n");
			}
		}
		// 시간이 짝수면 무조건 O으로 채워진 map이 출력됨
		else if (T % 2 == 0) {
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					sb.append('O');
				}
				sb.append("\n");
			}
		}
		// 시간이 홀수일 때 (폭탄이 터졌을 때)
		else {
			// 첫번째 폭탄이 터졌을 때의 맵
			boolean[][] change1 = new boolean[N][M]; // 터진 영역 = true,  폭탄이 있는 영역 = false
			
			while(!bomb.isEmpty()) {
				int[] now = bomb.pop();
				 for(int[] mv : move) {
					 int nextn = now[0] + mv[0];
					 int nextm = now[1] + mv[1];
					 
					 if (nextn < 0 || nextm < 0 || nextn >= N || nextm >= M) continue;
					 if (change1[nextn][nextm]) continue;
						 
					 change1[nextn][nextm] = true;
				 }
			}
			
			// 첫번째 폭탄이 터졌을 때의 맵 반전하기 (O <-> .) 
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if (!change1[n][m]) bomb.add(new int[] {n, m});
				}
			}
			
			// 두번째 폭탄이 터졌을 때의 맵
			boolean[][] change2 = new boolean[N][M]; // 터진 영역 = true,  폭탄이 있는 영역 = false
			while(!bomb.isEmpty()) {
				int[] now = bomb.pop();
				 for(int[] mv : move) {
					 int nextn = now[0] + mv[0];
					 int nextm = now[1] + mv[1];
					 
					 if (nextn < 0 || nextm < 0 || nextn >= N || nextm >= M) continue;
					 if (change2[nextn][nextm]) continue;
					 change2[nextn][nextm] = true;
				 }
			}
			
			// 출력 부분
			if (((T+1) /2) % 2 == 1) {
				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						if(change2[n][m]) sb.append('.');
						else sb.append('O');
					}
					sb.append("\n");
				}
			}
			else {
				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						if(change1[n][m]) sb.append('.');
						else sb.append('O');
					}
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}

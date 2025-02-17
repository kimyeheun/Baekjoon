import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int[][] move = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}};
	static int[][] map;
	static boolean win = false;
	static int resultN;
	static int resultM;
	
	static void checkWin(int n, int m, int type) {
		for(int[] mv : move) {
			int cnt = 0;
			int beforen = n - mv[0];
			int beforem = m - mv[1];
			int nown = n;
			int nowm = m;
			
			// 이전 
			if (beforen >= 0 && beforem >= 0 && beforen < 19 && beforem < 19) {
				while(map[beforen][beforem] == type) {
					cnt++;
					beforen -= mv[0];
					beforem -= mv[1];
					
					if (beforen < 0|| beforem < 0 ||beforen >= 19 ||beforem >= 19) break;
					if (cnt > 5) break;
				}
			}
			
			// 이후 
			while(map[nown][nowm] == type) {
				cnt++;
				nown += mv[0];
				nowm += mv[1];
				
				if (nown < 0|| nowm < 0 ||nown >= 19 ||nowm >= 19) break;
				if (cnt > 5) break;
			}
			
			if (cnt == 5) {
				win = true; 
				resultN = beforen + mv[0];
				resultM = beforem + mv[1];
				return;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		
		for(int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if (map[i][j] != 0) {
					checkWin(i, j, map[i][j]);
					if (win) {
						System.out.println(map[i][j] + "\n" + (resultN + 1) + " " + (resultM + 1));
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] connected = new int[N][N];
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < N; m++) {
				if(n == m) continue;
				connected[n][m] = Integer.MAX_VALUE;
			}
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			connected[n1][n2] = 1;
		}
		
		for(int i = 0; i < N; i++) {
			for(int s = 0; s < N; s++) {
				for(int e = 0; e < N; e++) {
					if(connected[s][i] == Integer.MAX_VALUE || connected[i][e] == Integer.MAX_VALUE) continue;
					connected[s][e] = Math.min(connected[s][i] + connected[i][e], connected[s][e]);
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			boolean row = true;
			for(int j = 0; j < N; j++) {
				if (connected[i][j] == Integer.MAX_VALUE && connected[j][i] == Integer.MAX_VALUE) row = false;
			}

			if (row) result++;
		}

		System.out.println(result);
	}
}

import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static Food[] foods;
	static int minResult = Integer.MAX_VALUE;
	
	static class Food {
		int sin;
		int ssen;
		
		Food(int sin, int ssen) {
			this.sin = sin;
			this.ssen = ssen;
		}
	}
	
	static void backTracking(int cnt, int idx, int sinS, int ssenS) {
		if (idx >= N) {
			if (cnt == 0) return;
			minResult = Math.min(minResult, Math.abs(sinS - ssenS));
			return;
		}
		
		backTracking(cnt+1, idx+1, sinS * foods[idx].sin, ssenS + foods[idx].ssen);
		backTracking(cnt, idx+1, sinS, ssenS);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		foods = new Food[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sin = Integer.parseInt(st.nextToken());
			int ssen = Integer.parseInt(st.nextToken());
			foods[i] = new Food(sin, ssen);
		}
		
		backTracking(0, 0, 1, 0);
		
		System.out.println(minResult);
	}
}

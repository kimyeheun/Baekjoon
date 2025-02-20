import java.io.*;
import java.util.*;


public class Main {
	static class KOI {
		int idx;
		int h;
		
		KOI(int idx, int h) {
			this.idx = idx;
			this.h = h;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] building = new int[N+1];
		int[] result = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<KOI> queue = new PriorityQueue<>((s, e) -> s.h - e.h);
		
		for(int i = N; i >= 0; i--) {
			while(true) {
				if(!queue.isEmpty() && queue.peek().h <= building[i]) {
					result[queue.remove().idx] = i;
				}
				else {
					queue.add(new KOI(i, building[i]));
					break;
				}
			}
		}
		
		while(queue.isEmpty()) {
			result[queue.remove().idx] = 0;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}

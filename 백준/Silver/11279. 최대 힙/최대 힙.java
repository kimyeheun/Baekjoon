import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int n = 0; n < N; n++) {
			int now = Integer.parseInt(br.readLine());
			if (now == 0) {
				if (queue.isEmpty()) sb.append(0);
				else sb.append(queue.poll());
				sb.append("\n");
			}
			else queue.add(now);
		}
		System.out.println(sb);
	}
}

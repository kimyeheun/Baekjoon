import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long result = 0;
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		Map<Long, Integer> nums = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		long now = 0;
		for (int n = 0; n < N; n++) { 
			now += Integer.parseInt(st.nextToken());

			if (now == K) result++;
			if (nums.containsKey(now-K)) result += nums.get(now - K);
			nums.put(now, nums.getOrDefault(now, 0) + 1);
		}
		
		System.out.println(result);
	}
} 

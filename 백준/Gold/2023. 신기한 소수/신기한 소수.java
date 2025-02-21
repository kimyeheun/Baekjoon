import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int[] vaildNum = {1, 3, 5, 7, 9};
	static Set<Integer> notPrime = new HashSet<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>((s, e) -> s-e);

	static boolean checkIsPrime(int num) {
		if (num < 2) return false;
		while(true) {
			for(int i = 2; i*i <= num; i++) {
				if (num % i == 0) return false;
			}
			num /= 10;
			if(num == 0) break;
		}
		return true;
	}
	
	static void backTracking(int cnt, int num) {
		if(cnt == N-1) {
			for(int n: vaildNum) {
				num = num * 10 + n;
				if (checkIsPrime(num)) pq.add(num);
				num /= 10;
			}
			return;
		}
		
		for(int i : vaildNum) {
			backTracking(cnt+1, num*10 + i);
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			sb.append(2).append("\n").append(3).append("\n").append(5).append("\n").append(7).append("\n");
			System.out.println(sb);
			return;
		}
		// 2로 시작
		backTracking(1, 2);
		// 3으로 시작
		backTracking(1, 3);
		// 5으로 시작
		backTracking(1, 5);
		// 7으로 시작
		backTracking(1, 7);
		
		while(!pq.isEmpty()) sb.append(pq.remove()).append("\n");
		System.out.println(sb);
	}
}

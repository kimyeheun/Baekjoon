import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			deque.addFirst(i);
		}
		
		while(deque.size() > 1) {
			deque.removeLast();
			deque.addFirst(deque.removeLast());
		}
		
		System.out.println(deque.remove());
	}
}

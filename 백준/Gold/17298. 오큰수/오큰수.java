import java.util.*;
 
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int N = in.nextInt();
		int[] seq = new int[N];
		
		for(int i = 0; i < N; i++) {
			seq[i] = in.nextInt();
		}
 
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
				seq[stack.pop()] = seq[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			seq[stack.pop()] = -1;
		}
		
		for(int u = 0; u < N; u++) {
			sb.append(seq[u]).append(' ');
		}
		System.out.println(sb);
	}
}
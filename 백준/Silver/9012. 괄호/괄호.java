import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			Stack<Byte> stack = new Stack<>();
			String line = br.readLine();
			boolean success = true;
			
			for(char c : line.toCharArray()) {
				if (c == '(') stack.add((byte)1);
				else {
					if (stack.isEmpty()) {
						success = false;
						break;
					}
					else stack.pop();
				}
			}
			if (!stack.isEmpty())
				success = false;
			System.out.println(success ? "YES" : "NO");
		}
	}
}


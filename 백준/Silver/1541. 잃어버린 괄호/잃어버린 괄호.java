import java.io.*;
import java.util.*;


public class Main {
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer lines = new StringTokenizer(line, "\\+|\\-", true);
		
		List<Integer> nums = new LinkedList<>();
		List<Character> calc = new LinkedList<>();
		
		nums.add(Integer.parseInt(lines.nextToken()));
		while(lines.hasMoreTokens()) {
			calc.add(lines.nextToken().charAt(0));
			nums.add(Integer.parseInt(lines.nextToken()));
		}
		
		int idx = 0;
		while (true) {
			if(!calc.contains('+')) break;
			if(calc.get(idx) == '+') {
				int n1 = nums.remove(idx);
				int n2 = nums.remove(idx);
				calc.remove(idx);
				nums.add(idx, n1+n2);
			}
			else idx++;
		}

		idx = 0;
		while (true) {
			if(calc.isEmpty()) break;
			if(calc.remove(idx) == '-') {
				int n1 = nums.remove(idx);
				int n2 = nums.remove(idx);
				
				nums.add(idx, n1-n2);
			}
		}
		
		System.out.println(nums.remove(0)); 
	}
}

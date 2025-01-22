import java.io.*;
import java.util.*;


public class Main {
	
	static String search(String[] strs) {
		String result;
		
		if (strs.length == 1) return "YES"; 
		else {
			for(int i = 0; i < strs.length / 2; i++) {
				if (Integer.parseInt(strs[i]) + Integer.parseInt(strs[strs.length -i -1]) != 1)
					return "NO";
			}
		}
		result = search(Arrays.copyOfRange(strs, 0, strs.length / 2));
		result = search(Arrays.copyOfRange(strs, strs.length / 2 + 1, strs.length));
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String str = br.readLine();

			if (str.length() == 1) {
				System.out.println("YES");
				continue;
			}
			
			String[] strs = str.split("");
			
			int num0 = 0;
			int num1 = 0;
			
			for(String s : Arrays.copyOfRange(strs, 0, strs.length / 2)) {
				if (s.equals("0")) num0++;
				else num1++;
			}

			if (Math.abs(num0 - num1) != 1) {
				System.out.println("NO");
				continue;
			}
			
			System.out.println(search(strs));
		}
	}
}


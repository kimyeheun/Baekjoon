import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		for(int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		for(int n = 0; n < N; n++) 
			sb.append(nums[n]).append("\n");
		
		System.out.println(sb);
	}
}

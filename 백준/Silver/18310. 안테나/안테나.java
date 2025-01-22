import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] homes = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			homes[n] = Integer.parseInt(st.nextToken());
		}
		
		if (N == 1) {
			System.out.println(homes[0]);
			return;
		}
		
		Arrays.sort(homes);
		
		int result = 0;
		int sum = 0;
		int buf_sum = Integer.MAX_VALUE;
		
		for(int i = N / 2 - 1; i < N / 2 + 1; i++) {			
			sum = 0;
			for (int n = 0; n < N; n++) {
				sum += Math.abs(homes[n] - homes[i]);
			}
			if (sum < buf_sum) result = homes[i];
			buf_sum = sum;
		}
		
		System.out.println(result);
    }
}

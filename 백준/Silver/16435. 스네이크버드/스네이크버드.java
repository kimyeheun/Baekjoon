import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] eat = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			eat[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(eat);
		for(int e : eat) {
			if (L >= e) L++;
			else break;
		}
		System.out.println(L);
	}
} 

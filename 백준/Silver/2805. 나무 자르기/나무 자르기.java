import java.io.*;
import java.util.*;


public class Main {
	static int[] trees;
	static int result = 0;
	static int N;
	static int M;
	
    static void binarySearch(int s, int e) {
        while (s <= e) {
            int nowL = (s + e) / 2;
            long bufResult = 0;
            
            for (int i = 0; i < N; i++) {
                if (trees[i] > nowL) 
                    bufResult += trees[i] - nowL;
            }
            if (bufResult >= M) {
                result = nowL;
                s = nowL + 1;
            } 
            else 
                e = nowL - 1;
        }
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		N = Integer.parseInt(st.nextToken()); // 나무 개수 
		M = Integer.parseInt(st.nextToken()); // 가져갈 수 있는 나무의 길이
		
		trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		binarySearch(0, trees[N-1]);
		System.out.println(result);
		
	}
}

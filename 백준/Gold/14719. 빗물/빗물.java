import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] rain = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int m = 0; m < M; m++) {
            rain[m] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        for(int n = 1; n <= N; n++) {
        	List<Integer> idxs = new ArrayList<>();
        	for(int m = 0; m < M; m++) {
        		if (rain[m] >= n) idxs.add(m);
        	}
    		
        	if (idxs.isEmpty()) continue;
        	
        	int s = idxs.remove(0);
        	for(int e : idxs) {
        		for(int i = s + 1; i < e; i++) {
        			result++;
        		}
        		s = e;
        	}
        }
        
        System.out.println(result);
	}
}


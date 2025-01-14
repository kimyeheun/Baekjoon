import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int s = 0; s<N; s++) {
        	S[s] = Integer.parseInt(st.nextToken());
        }
        
        HashSet<Integer> al = new HashSet<>();
        
        for (int bit = 1; bit < (1<<N); bit++) {
        	int sum = 0;
        	for (int i = 0; i < N; i++) {
        		if ((bit & (1 << i)) != 0) {
        			sum += S[i];
        		}
        	}
        	al.add(sum);
        }
        List<Integer> all = new ArrayList<>(al);
        Collections.sort(all);

        int result = 1;
        for (int a : all) {
        	if (result != a)  
        		break;
        	result++;
        }
        
        System.out.println(result);
        
    }
}
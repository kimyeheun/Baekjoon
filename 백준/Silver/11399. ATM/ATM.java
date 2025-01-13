import java.io.*;
import java.util.*;

// 그리디
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int n = 0; n < N; n++) {
            p[n] = Integer.parseInt(st.nextToken());           
        }
        
        Arrays.sort(p);

        int result = 0;
        int sum = 0;
        for (int n = 0; n < N; n++) {
            sum += p[n];
            result += sum;            
        }
        
        System.out.println(result);
    }
}

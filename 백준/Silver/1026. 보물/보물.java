import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] n1 = new int[N];
        int[] n2 = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n= 0; n < N; n++){
            n1[n] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int n= 0; n < N; n++){
            n2[n] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(n1);
        Arrays.sort(n2);
        
        int result =0;
        for (int i =0; i <N; i++){
            result += (n1[i] * n2[N-1-i]);
        }
        
        System.out.println(result);
    }
}    
            
            
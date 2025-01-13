import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        
        String group1 = br.readLine(); 
        String group2 = br.readLine(); 
        int T = Integer.parseInt(br.readLine());
        
        char[] result = new char[N1 + N2];
        for (int i = 0; i < N1; i++) {
            result[N1 - i - 1] = group1.charAt(i);
        }
        for (int i = 0; i < N2; i++) {
            result[N1 + i] = group2.charAt(i); 
        }
        
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < result.length - 1; i++) {
                if (group1.indexOf(result[i]) != -1 && group2.indexOf(result[i + 1]) != -1) {
                    char temp = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = temp;
                    i++; 
                }
            }
        }
        
        System.out.println(new String(result));
    }
}

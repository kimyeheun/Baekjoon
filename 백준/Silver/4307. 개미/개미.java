import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); 

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); 
            int N = Integer.parseInt(st.nextToken()); 
            
            int minTime = 0;
            int maxTime = 0;

            for (int n = 0; n < N; n++) {
                int pos = Integer.parseInt(br.readLine());
                
                int timeL = pos;
                int timeR = L - pos;

                minTime = Math.max(minTime, Math.min(timeL, timeR)); 
                maxTime = Math.max(maxTime, Math.max(timeL, timeR)); 
            }

            System.out.println(minTime + " " + maxTime);
        }
    }
}

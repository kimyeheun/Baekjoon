import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st  =new StringTokenizer(line, "+|-", true);

        int[] minus = new int[line.length()];
        int j = 0;
        int fir = Integer.parseInt(st.nextToken());

        while(st.hasMoreTokens()) {
            String opera = st.nextToken();
            int sec = Integer.parseInt(st.nextToken());
            if(opera.equals("+"))
                fir = fir + sec;
            if(opera.equals("-")) {
                minus[j++] = fir;
                fir = sec;
            }
        }

        minus[j] = fir;
        int sum = minus[0];

        for (int i = 1; i < minus.length; i++) {
            sum -= minus[i];
        }
        System.out.println(sum);
    }
}
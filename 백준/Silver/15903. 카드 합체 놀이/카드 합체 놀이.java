import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] card = new long[N];

        line = br.readLine();
        st  = new StringTokenizer(line);
        for (int n = 0; n < N; n++) {
            card[n] = Integer.parseInt(st.nextToken());
        }

        for (int m = 0; m < M; m++) {
            Arrays.sort(card);
            card[0] = card[1] = card[0] + card[1];
        }

        long sum = 0;
        for (int n = 0; n < N; n++) {
            sum += card[n];
        }
        System.out.println(sum);
    }
}
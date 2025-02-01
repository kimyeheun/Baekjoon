import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i =0; i< N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for(int i = N-1; i >= 0; i--) {
            if (K == 0) break;
            if (coins[i] <= K) {
                result += (K/coins[i]);
                K = K % coins[i];
            }
        }
        System.out.println(result);
    }
}

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] add = new long[K+1][N+1];
        Arrays.fill(add[0],0);
        Arrays.fill(add[1],1);

        for (int k = 2; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                if (n == 0) add[k][n] = 1;
                else add[k][n] = (add[k-1][n] + add[k][n-1]) % 1000000000;
            }
        }
        System.out.println(add[K][N]);
    }
}

import java.io.*;
import java.util.*;


public class Main {

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        int[] mins = new int[N-1];

        trees[0] = Integer.parseInt(br.readLine());
        for (int n = 1; n < N; n++) {
            trees[n] = Integer.parseInt(br.readLine());
            mins[n-1] = trees[n] - trees[n-1];
        }

        int min = mins[0];
        for (int n = 1; n < N-1; n++) {
            min = Math.min(min , gcd(mins[n], min));
        }

        int result = 0;
        for (int n = 1; n < N; n++) {
            int gap = trees[n] - trees[n-1];
            if (gap != min) {
                result += (gap/ min -1);
            }
        }

        System.out.println(result);

    }
}

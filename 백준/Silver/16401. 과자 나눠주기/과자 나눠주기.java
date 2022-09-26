import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        long N = sc.nextInt();
        int[] snack = new int[(int)N];

        for (int n = 0; n < N; n++) {
            snack[n] = sc.nextInt();
        }

        Arrays.sort(snack);
        long s = 1;
        long e = snack[(int)N-1];

        long ans = 0;

        while(s <= e) {
            long m = (s + e) / 2;
            long sum = 0;
            for (int n = 0; n < N; n++) {
                sum += snack[n] / m;
            }

            if(sum >= M) {
                if(ans < m)
                    ans = m;
                s = m + 1;
            }
            else
                e = m - 1;
        }

        System.out.println(ans);

    }
}
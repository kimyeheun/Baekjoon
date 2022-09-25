import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        long N = sc.nextInt();
        int[] line = new int[K];

        long min = 1;
        long max = 0;

        for (int k = 0; k < K; k++) {
            line[k] = sc.nextInt();
            if(max < line[k])
                max = line[k];
        }

        long ans = 0;

        while(min <= max) {
            long mid = (min + max) / 2;
            int sum = 0;
            for (int k = 0; k < K; k++) {
                sum += (line[k] / mid);
            }
            if(sum >= N) {
                min = mid + 1;
                ans = mid;
            }
            else
                max = mid - 1;
        }
        System.out.println(ans);
    }
}
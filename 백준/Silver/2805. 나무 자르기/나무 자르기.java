import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] trees = new int[N + 1];
        long max = 0;
        
        for (int i = 1; i <= N; i++) {
            trees[i] = scanner.nextInt();
            max = Math.max(max, trees[i]);
        }

        long start = 0;

        while (start <= max) {
            long mid = (start + max) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum >= M) {
                start = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(max);
    }
}
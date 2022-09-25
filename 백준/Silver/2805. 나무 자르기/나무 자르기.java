import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long M = sc.nextLong(); //가져가는 나무의 길이가 M이랑 같거나 커도 됨.
        long[] tree = new long[N];

        long min = 0;
        long max = 0;

        for (int n = 0; n < N; n++) {
            tree[n] = sc.nextInt();
            if(max < tree[n])
                max = tree[n];
        }

        while(min <= max) {
            long bring = 0;
            long mid = (min + max) / 2;

            for (int n = 0; n < N; n++) {
                if(tree[n] - mid > 0)
                    bring += tree[n] - mid;
            }

            if(bring >= M) {
                min = mid + 1;
            }
            else
                max = mid - 1;
        }
        System.out.println(max);
    }
}
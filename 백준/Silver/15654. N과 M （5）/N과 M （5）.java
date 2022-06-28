import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int[] arr;

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        num = new int[N];
        visit = new boolean[N];
        arr = new int[M];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);
        backtracking(0);
        System.out.println(sb);
    }
    static void backtracking(int count) {
        if(count == M) {
            for(int u : arr) {
                sb.append(u).append(" ");
            }
            sb.append("\n");
        }
        else {
            for(int i = 0; i < N; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    arr[count] = num[i];
                    backtracking(count+1);
                    visit[i] = false;
                }
            }
        }
    }
}

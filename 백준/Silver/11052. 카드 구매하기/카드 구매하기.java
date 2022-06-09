import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N  = sc.nextInt();
        int[] card = new int[N+1];

        for(int i = 1; i <=N; i++) {
            card[i] = sc.nextInt();
        }

        int[] max_card = new int[N+1];
        max_card[0] = 0;
        max_card[1] = card[1];

        for(int u = 1; u <=N; u++) {
            for(int y = 1; y <=u; y++) {
                max_card[u] = Math.max(max_card[u], max_card[u-y] + card[y]);
            }
        }
        System.out.println(max_card[N]);
    }
}
import java.util.*;
//dp 카드

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N  = sc.nextInt();
        int[] card = new int[N+1];

        for(int i = 1; i <=N; i++) {
            card[i] = sc.nextInt();
        }

        int[] min_card = new int[N+1];
        min_card[1] = card[1];

        for(int u = 2; u <=N; u++) {
            min_card[u] = card[u];
            for(int y = 1; y < u; y++) {
                min_card[u] = Math.min(min_card[u], min_card[u-y] + card[y]);
            }
        }
        System.out.println(min_card[N]);
    }
}
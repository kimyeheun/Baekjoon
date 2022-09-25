import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc =  new Scanner(System.in);
        int G = sc.nextInt();

        int[] grape = new int[G+1];
        int[] dp = new int[G+1];

        for (int i = 1; i <= G; i++) {
            grape[i] = sc.nextInt();
        }

        for (int i = 1; i <= G; i++) {
            if(i == 1)
                dp[i] = grape[i];
            else if(i == 2)
                dp[i] = grape[1] + grape[2];
            else
                dp[i] = Math.max(Math.max(dp[i-3] + grape[i-1] + grape[i], dp[i-1]), dp[i-2] + grape[i]);
        }

        int max = 0;

        for (int i = 1; i <= G; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
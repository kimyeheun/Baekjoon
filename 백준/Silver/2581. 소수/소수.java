import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean[] prime = new boolean[b+1];
        prime[0] = prime[1] = true;
        for(int i = 2; i<=b; i++) {
            if(!prime[i]) {
                for(int u = i+i; u <=b; u +=i) {
                    prime[u] = true;
                }
            }
        }

        int sum = 0;
        int small = -1;
        for(int y = a; y <= b; y++) {
            if(!prime[y]) {
                if (sum == 0)
                    small = y;
                sum += y;
            }
        }
        if(sum == 0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(small);
        }

    }
}
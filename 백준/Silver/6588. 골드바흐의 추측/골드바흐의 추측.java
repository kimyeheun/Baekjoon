import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        //1000000이하의 소수를 구한다.
        int num = 1000000;
        boolean[] isPrime = new boolean[num+1];

        isPrime[0] = isPrime[1] = true;
        for(int r = 2; r*r <= num; r++) {
            if(!isPrime[r]){
                for(int e = 2* r; e <=num; e+=r)
                    isPrime[e] = true;
            }
        }

        int n = Integer.parseInt(sc.readLine());
        while(n != 0) {
            boolean isProve = false;
            for(int i = 2; i <= n / 2; i++) {
                if(!isPrime[i] && !isPrime[n-i]){
                    System.out.printf("%d = %d + %d\n", n, i, n-i);
                    isProve = true;
                    break;
                }
            }
            if(!isProve)
                System.out.println("Goldbach's conjecture is wrong");
            n = Integer.parseInt(sc.readLine());
        }
    }
}
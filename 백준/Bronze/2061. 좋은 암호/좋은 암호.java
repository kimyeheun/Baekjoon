import java.math.BigInteger;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
       Scanner sc = new Scanner(System.in);

        BigInteger K = sc.nextBigInteger();
        int L = sc.nextInt();
        int N = 0;

        for (int i = 2; i < L; i++) {
            if(K.remainder(BigInteger.valueOf(i)).compareTo(BigInteger.ZERO)==0) {
            N = i;
            break;
            }
        }
        String s = (N>0) ? ("BAD " + N) : "GOOD";
        System.out.println(s);
    }
}
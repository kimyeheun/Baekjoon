import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        int a = Integer.parseInt(sc.next());
        int b = Integer.parseInt(sc.next());

        int min = Math.min(a, b);

        int first = 1;
        int second = 1;

        for (int i = 2; i < min+1; i++) {
            if (a%i==0 && b%i==0) {
                first *= i;
                a = a / i;
                b = b / i;
                i = 1;
            }
        }
        second = first*a*b;
        System.out.println(first);
        System.out.println(second);
    }
}
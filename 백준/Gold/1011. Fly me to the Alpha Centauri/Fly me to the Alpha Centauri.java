import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 0; i < test; i++) {
            int start = sc.nextInt();
            int fin = sc.nextInt();
            int count = fin - start;
            int m = (int) Math.sqrt(count);

            if (m * m == count)
                System.out.println(2 * m - 1);
            else if (m * m + m >= count)
                System.out.println(2 * m);
            else
                System.out.println(2 * m + 1);
        }
    }
}

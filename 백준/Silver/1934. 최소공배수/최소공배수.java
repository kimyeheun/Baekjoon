import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt();
        for(int i = 0; i < test; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a>b) {
                System.out.println(a*b/uc(a, b));
            }
            else {
                System.out.println(a*b/uc(b, a));
            }
        }
    }
    public static int uc(int a, int b) {
        int c = a % b;
        while(true) {
            if (c == 0)
                return b;
            a = b;
            b = c;
            c = a % b;
        }
    }
}
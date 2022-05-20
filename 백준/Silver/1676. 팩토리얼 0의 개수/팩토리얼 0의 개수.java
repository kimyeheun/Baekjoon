import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c2 = 0;
        int c5 = 0;

        if(a == 0){
            System.out.println(0);
        }
        else {
            for (int i = 2; i <= a; i++) {
                int temp = i;
                while(temp%2 ==0) {
                    c2++;
                    temp /= 2;
                }
                while(temp%5==0) {
                    c5++;
                    temp /= 5;
                }
            }
            int min = (c2>c5) ? c5 : c2;
            System.out.println(min);
        }
    }
}
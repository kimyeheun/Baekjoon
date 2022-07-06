import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int res = 0;
        res = Math.min(w-x, h-y);
        res = Math.min(res, x);
        res = Math.min(res, y);
        
        System.out.println(res);
    }
}
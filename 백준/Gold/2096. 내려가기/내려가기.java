import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int floor = sc.nextInt();

        int[] now = new int[3];
        int[] maxp = new int[3];
        int[] minp = new int[3];

        maxp[0] = sc.nextInt();
        maxp[1] = sc.nextInt();
        maxp[2] = sc.nextInt();

        minp[0] = maxp[0];
        minp[1] = maxp[1];
        minp[2] = maxp[2];

        for(int i = 1; i < floor; i++) {
            now[0] = sc.nextInt();
            now[1] = sc.nextInt();
            now[2] = sc.nextInt();

            int ax = maxp[0];
            int bx = maxp[2];
            maxp[0] = Math.max(maxp[0], maxp[1]) + now[0];
            maxp[2] = Math.max(maxp[1], maxp[2]) + now[2];
            maxp[1] = Math.max(Math.max(maxp[1], bx), ax) + now[1];

            int an = minp[0];
            int bn = minp[2];
            minp[0] = Math.min(minp[0], minp[1]) + now[0];
            minp[2] = Math.min(minp[1], minp[2]) + now[2];
            minp[1] = Math.min(Math.min(minp[1], bn), an) + now[1];
        }

        System.out.print(Math.max(Math.max(maxp[0], maxp[1]),maxp[2]));
        System.out.print(" ");
        System.out.println(Math.min(Math.min(minp[0], minp[1]),minp[2]));
    }
}

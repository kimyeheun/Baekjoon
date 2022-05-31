import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");

        long first = Long.parseLong(num[0]+num[1]);
        long second = Long.parseLong(num[2]+num[3]);

        System.out.println(first+second);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 7 ; i++) {
            int x = sc.nextInt();
            if (x % 2 == 0) { //짝수일 때
                j++;
                continue;
            }
            sum += x;
            if (min > x)
                min = x;
        }

        if(j == 7)
            System.out.println(-1);
        else
            System.out.println(sum+"\n"+min);
    }
}

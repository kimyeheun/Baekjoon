import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // T개의 테스트를 진행

        for (int t = 0; t < T; t++) {
            int R = sc.nextInt();  //반복 횟수
            String S = sc.next();  //반복할 문자
            StringBuilder sb = new StringBuilder();

            for (int s = 0; s < S.length(); s++) {
                for (int r = 0; r < R; r++) {
                    sb.append(S.charAt(s));
                }
            }

            System.out.println(sb);
        }
    }
}

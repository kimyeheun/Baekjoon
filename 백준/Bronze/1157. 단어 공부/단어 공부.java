import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        word = word.toUpperCase(Locale.ROOT);
        int[] alpa = new int[26];

        for (int i = 0; i < word.length(); i++) {
            alpa[word.charAt(i)-65]++;
        }

        int max = alpa[0];
        int ans = 0;
        int cnt = 1;

        for (int i = 1; i < alpa.length; i++) {
            if(max == alpa[i]) {
                cnt = 0;
            }
            if(max < alpa[i]) {
                max = alpa[i];
                ans = i;
                cnt = 1;
            }
        }

        if(cnt == 0)
            System.out.println("?");
        else
            System.out.println((char)(ans + 65));
    }
}
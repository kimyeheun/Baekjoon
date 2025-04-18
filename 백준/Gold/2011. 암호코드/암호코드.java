import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        long[] dp = new long[word.length() + 1];
        if (word.startsWith("0")) {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;
        if (word.length() >= 2) {
            for (int i = 2; i <= word.length(); i++) {
                long num = Long.parseLong(word.substring(i - 2, i));
                // 00 <- 거르기
                if (num == 0 || (num % 10 == 0 && num >= 30)) {
                    System.out.println(0);
                    return;
                }
                // 10, 20 이 나오면, dp[i-2]를 가져옴
                if (num == 10 || num == 20) {
                    dp[i] = dp[i - 2] % 1000000;
                    continue;
                }

                if (num > 26 || word.charAt(i-1) - '0' == 0 || word.charAt(i-2) - '0' == 0) {
                    dp[i] = dp[i - 1] % 1000000;
                }
                else {
                    dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000;
                }
            }
        }
        System.out.println(dp[word.length()]);
    }
}

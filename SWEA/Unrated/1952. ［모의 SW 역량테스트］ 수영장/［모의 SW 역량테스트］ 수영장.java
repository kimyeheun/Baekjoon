import java.io.*;
import java.util.*;


public class Solution {
    static int minCost = 0;
    static int[] dp;
    static int day1;
    static int month1;
    static int month3;
    static int[] month;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            month = new int[16];
            dp = new int[16];

            StringTokenizer st = new StringTokenizer(br.readLine());
            day1 = Integer.parseInt(st.nextToken());
            month1 = Integer.parseInt(st.nextToken());
            month3 = Integer.parseInt(st.nextToken());
            minCost = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int totalDay = 0;
            int totalMonth = 0;
            for(int i = 3; i < 15; i++) {
                month[i] = Integer.parseInt(st.nextToken());
                totalDay += month[i];
                totalMonth += (month[i] != 0 ? 1 : 0);
            }

            for(int i = 1; i <= 15; i++) {
                if (month[i] == 0) dp[i] = dp[i-1];
                else {
                    int now1 = dp[i-1] + day1 * month[i];
                    int now2 = dp[i-1] + month1;
                    int now3 = dp[i-3] + month3;
                    dp[i] = Math.min(now1, Math.min(now2, now3));
                }
            }
            minCost = Math.min(minCost, dp[15]);
            sb.append("#").append(t).append(" ").append(minCost).append("\n");
        }

        System.out.println(sb);
    }
}
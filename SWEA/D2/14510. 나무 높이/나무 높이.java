import java.util.*;
import java.io.*;

public class Solution {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];
            int max = 0;
            int[] totalR = new int[2]; // totalR[0]: 홀수, totalR[1]: 짝수

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int n = 0; n < N; n++) {
                trees[n] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[n]);
            }

            for (int n = 0; n < N; n++) {
                int diff = max - trees[n];  // 목표 높이까지 자라야 하는 길이
                totalR[0] += diff % 2;      // 1씩 성장해야 하는 홀수 날
                totalR[1] += diff / 2;      // 2씩 성장해야 하는 짝수 날
            }

            // 짝수 날을 일부 변환하여 홀수 날과 균형 맞추기
            int temp = Math.max(totalR[1] - totalR[0], 0) / 3;
            totalR[0] += temp * 2;
            totalR[1] -= temp;

            int oddEvenMin = Math.min(totalR[0], totalR[1]);
            int totalDays = oddEvenMin * 2
                    + Math.max((totalR[0] - oddEvenMin) * 2 - 1, 0)
                    + (totalR[1] - oddEvenMin) / 2 * 3
                    + (totalR[1] - oddEvenMin) % 2 * 2;

            System.out.println("#" + t + " " + totalDays);
        }
    }
}

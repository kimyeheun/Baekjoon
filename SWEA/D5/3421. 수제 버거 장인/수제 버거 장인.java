import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int Result;
    static Map<Integer, Integer> map;

    static void backTracking(int idx, int nowPossibleNums) {
        if (idx > N) {
            Result++;
            return;
        }

        // idx를 넣는 경우
        if ((nowPossibleNums & (1 << (idx - 1))) != 0) 
            backTracking(idx + 1, nowPossibleNums & map.get(idx));

        // idx를 넣지 않는 경우
        backTracking(idx + 1, nowPossibleNums);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            Result = 0;
            map = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 모든 재료가 포함된 초기값 설정
            for (int i = 1; i <= N; i++) {
                map.put(i, (1 << N) - 1);  
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map.put(a, map.get(a) & ~(1 << (b - 1)));
                map.put(b, map.get(b) & ~(1 << (a - 1)));
            }

            backTracking(1, (1 << N) - 1);
            System.out.println("#" + t + " " + Result);
        }
    }
}

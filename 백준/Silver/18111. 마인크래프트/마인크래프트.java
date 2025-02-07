import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[n][m]);
                min = Math.min(min, map[n][m]);
            }
        }

        int resultH = -1; // 높이 결과
        int resultT = Integer.MAX_VALUE; // 시간 결과

        for (int top = min; top <= max; top++) {
            int time = 0;
            int block = B; // 인벤토리의 블록 수

            for(int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    if (map[n][m] > top) {
                        block += (map[n][m] - top);
                        time += (map[n][m] - top) * 2;
                    }
                    else if (map[n][m] < top){
                        block -= (top - map[n][m]);
                        time += (top - map[n][m]);
                    }
                }
            }
            if (block >= 0) {
                if (time < resultT || (time == resultT && top > resultH)) {
                    resultH = top;
                    resultT = time;
                }
            }
        }

        System.out.println(resultT + " " + resultH);
    }
}
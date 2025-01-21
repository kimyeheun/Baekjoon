import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        long result = 0L;

        while (!(X == 0 && Y == 0)) {
            // 한 쪽이라도 0이라면,
            if (X == 0 || Y == 0) {
                // 대각선 길이와 직진 거리 비교
                int distance = X == 0 ? Y : X;

                if (S >= W) { // 직진으로 가야 함.
                    result += (long) distance * W;
                }
                else {
                    if (distance % 2 == 0) {
                        result += (long) distance * S;
                    }
                    else result += ((long) (distance - 1) * S + W);
                }

                X = 0;
                Y = 0;
            }
            // 아직 올라가야 한다면
            else {
                int min = Math.min(X, Y);

                if (W * 2 <= S) { // 가로 세로 이동
                    result += (long) W * min * 2;
                }
                else { // 대각선 이동
                    result += (long) min * S;
                }

                X = X == min ? 0 : X - min;
                Y = Y == min ? 0 : Y - min;
            }
        }

        System.out.println(result);
    }
}

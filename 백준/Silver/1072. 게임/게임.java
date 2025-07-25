import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 총 게임 수
        long X = Long.parseLong(st.nextToken()); 
        // 이긴 게임 수
        long Y = Long.parseLong(st.nextToken()); 

        int currentRate = (int) (Y * 100 / X);

        // 승률이 절대로 변하지 않는 경우
        if (currentRate >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1_000_000_000;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long newRate = (Y + mid) * 100 / (X + mid);

            if (newRate > currentRate) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}

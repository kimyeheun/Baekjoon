import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = (N % 5 == 0) ? N / 5 : (N % 3 ==0) ? N / 3 : Integer.MAX_VALUE;
        if (N == 4 || N < 3) {
            System.out.println(-1);
            return;
        }

        int now = N;
        int buf = 0;
        while (now > 7) {
            now -= 5;
            buf++;
            if (now % 3 == 0) {
                result = Math.min(now / 3 + buf, result);
            }
        }

        now = N;
        buf = 0;
        while (now > 7) {
            now -= 3;
            buf++;
            if (now % 5 == 0) {
                result = Math.min(now / 5 + buf, result);
            }
        }
        if (result == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(result);
    }
}

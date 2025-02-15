import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int M;

    static int[] result;
    static StringBuilder sb = new StringBuilder();

    static void backTracking(int idx, int now) {
        if (now > N) return;
        if (idx == M) {
            for(int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        result[idx] = now;
        backTracking(idx+1, now);
        backTracking(idx, now+1);

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        backTracking(0, 1);

        System.out.println(sb);
    }
}

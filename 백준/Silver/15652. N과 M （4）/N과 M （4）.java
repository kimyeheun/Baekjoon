import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] result;

    static void backTracking(int idx, int now, StringBuilder sb) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = now; i <= N; i++) {
            result[idx] = i;
            backTracking(idx + 1, i, sb);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        StringBuilder sb = new StringBuilder();
        backTracking(0, 1, sb);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

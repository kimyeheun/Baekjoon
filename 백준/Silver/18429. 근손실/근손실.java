import java.io.*;
import java.util.*;


class Main{
    static int N;
    static int result = 0;
    static int[] weights;

    static void backTracking(boolean[] visite, int num, int nowSum) {
        if (nowSum < 0) return;
        if (num == N) {
            result++;
            return;
        }

        for(int idx = 0; idx < N; idx++) {
            if (!visite[idx]) {
                visite[idx] = true;
                backTracking(visite, num + 1, nowSum + weights[idx]);
                visite[idx] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            weights[n] = Integer.parseInt(st.nextToken()) - K;
        }

        boolean[] visited = new boolean[N];
        backTracking(visited, 0, 0);


        System.out.println(result);

    }
}
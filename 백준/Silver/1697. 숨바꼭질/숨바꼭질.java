import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K <= N) {
            System.out.println(N - K);
            return;
        }

        int[] visited = new int[100_001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                System.out.println(visited[K]);
                return;
            }
            int[] nextPositions = {now - 1, now + 1, now * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100_000 && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }

        if(visited[N] == 0) System.out.println(-1);
        else System.out.println(visited[K]);
    }
}

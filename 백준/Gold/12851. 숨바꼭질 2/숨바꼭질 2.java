import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        int[] visited = new int[100_001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 0;
        int result = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            int[] next = {now+1, now-1, now*2};
            for(int n : next) {
                if (n < 0 || n > 100_000 || (visited[n] != 0 && visited[n] < visited[now] + 1)) continue;
                if (n == K) result++;
                queue.add(n);
                visited[n] = visited[now] + 1;
            }
        }

        if(visited[N] != 0) {
            System.out.println(visited[K]);
            System.out.println(result);
        }
    }
}

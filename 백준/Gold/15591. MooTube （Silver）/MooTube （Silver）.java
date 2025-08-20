import java.io.*;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 맵 초기화
        List<int[]>[] map = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }

        for(int n = 0; n < N-1; n++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            int q = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()); // 가중치
            map[p].add(new int[] {q, r});
            map[q].add(new int[] {p, r});
        }

        StringBuilder sb = new StringBuilder();
        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken()) - 1;

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N];
            visited[v] = true;
            for(int[] now : map[v]) {
                if (now[1] >= k) {
                    queue.add(now[0]);
                    visited[now[0]] = true;
                }
            }
            while(!queue.isEmpty()) {
                int now = queue.remove();
                for(int[] next : map[now]) {
                    if (next[1] < k) continue;
                    if (visited[next[0]]) continue;

                    queue.add(next[0]);
                    visited[next[0]] = true;
                }
            }

            int cnt = 0;
            for(int i = 0; i < N; i++) {
                if (visited[i]) cnt++;
            }
            sb.append(cnt-1).append("\n");
        }
        System.out.println(sb);

    }
}
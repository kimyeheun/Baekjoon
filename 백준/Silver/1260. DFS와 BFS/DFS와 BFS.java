import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static boolean[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int v) {
        if (visited[v]) return;

        sb.append(v).append(" ");
        visited[v] = true;

        for(int idx = 1; idx <= N; idx++) {
            if (graph[v][idx] && !visited[idx]) {
                dfs(idx);
            }
        }
    }

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = false;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");

            for(int idx = 1; idx <= N; idx++) {
                if (visited[idx] && graph[now][idx]) {
                    visited[idx] = false;
                    queue.add(idx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1][n2] = true;
            graph[n2][n1] = true;
        }

        // dfs
        dfs(V);

        sb.append("\n");
        // bfs
        bfs(V);

        System.out.println(sb);

    }
}

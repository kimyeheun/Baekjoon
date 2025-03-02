import java.io.*;
import java.util.*;


public class Main {
    static int INF =  Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int e;
        int w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return this.w - node.w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 (1~V)
        int E = Integer.parseInt(st.nextToken()); // 간선 (1~E)
        int K = Integer.parseInt(br.readLine()); // 시작 정점 번호 (0~V-1)

        // K에서 다른 노드까지의 최단 거리
        int[] minDist = new int[V+1];
        Arrays.fill(minDist, INF);
        minDist[K] = 0;

        // 간선 저장
        List<Node>[] routes = new ArrayList[V+1];
        for(int i = 1; i <= V; i++)
            routes[i] = new ArrayList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            routes[key].add(new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        // K번 노드부터 순회
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (minDist[now.e] < now.w) continue;

            for (Node next : routes[now.e]) {
                int newDist = minDist[now.e] + next.w;
                if (newDist < minDist[next.e]) {
                    minDist[next.e] = newDist;
                    pq.add(new Node(next.e, minDist[now.e] + next.w));
                }
            }
        }

        // minDist 출력
        StringBuilder sb = new StringBuilder();
        for(int v = 1; v <= V; v++) {
            if (minDist[v] == INF) sb.append("INF");
            else sb.append(minDist[v]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static ArrayList<Node>[] go;
    static ArrayList<Integer>[] record;
    static boolean[] visit;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        weight = new int[n+1];
        visit = new boolean[n+1];
        go = new ArrayList[n+1];
        record = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            go[i] = new ArrayList<>();
            record[i] = new ArrayList<>();
            weight[i] = Integer.MAX_VALUE;
        }

        //간선 기록
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            go[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        System.out.println(weight[end]);
        System.out.println(record[end].size());
        for (int i = 0; i < record[end].size(); i++) {
            System.out.print(record[end].get(i) + " ");
        }
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        visit[start] = true;
        record[start].add(start);

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(!visit[now.end]) {
                visit[now.end] = true;
                //record[now.end].add(pre);
            }
            if(now.end == end)
                return;
            for(Node next : go[now.end]) {
                if(!visit[next.end] && weight[next.end] >= next.cost + now.cost) {
                    weight[next.end] = next.cost + now.cost;
                    pq.add(new Node(next.end, weight[next.end]));

                    record[next.end].clear();
                    for (int u = 0; u < record[now.end].size(); u++) {
                        record[next.end].add(record[now.end].get(u));
                    } record[next.end].add(next.end);
                }
            }
        }
    }

    static class Node {
        int end;
        int cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] go;
    static int[] Bus;
    static boolean[] visit;

    public static class Node {
        int dest; //destination
        int cost;
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //도시의 개수 (노드)
        int M = Integer.parseInt(br.readLine()); //버스의 개수 (간선)

        go = new ArrayList[N+1];
        Bus = new int[N+1];
        visit = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            go[i] = new ArrayList<>();
            Bus[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            go[x].add(new Node(y, z));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        System.out.println(Bus[end]);
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(!visit[now.dest])
                visit[now.dest] = true;
            if(now.dest == end) {
                return;
            }
            for(Node next : go[now.dest]) {
                if(!visit[next.dest] && Bus[next.dest] > next.cost + now.cost) {
                    Bus[next.dest] = next.cost + now.cost;
                    pq.add(new Node(next.dest, Bus[next.dest]));
                }
            }
        }
    }
}

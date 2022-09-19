import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;


public class Main {
    static boolean[] Vv;            //노드 방문 여부
    static int[] Dv;                // 가중치 저장
    static ArrayList<Node>[] array; //Node 자료형을 가진 arrayList로 구성된 배열을 생성한다.

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); //정점 개수
        int E = Integer.parseInt(st.nextToken()); //간선 개수

        Vv = new boolean[V+1];
        Dv = new int[V+1];
        array = new ArrayList[V+1];

        int start = Integer.parseInt(br.readLine());
        Arrays.fill(Dv, Integer.MAX_VALUE);

        for (int i = 1; i <= V; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            array[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            if(Dv[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(Dv[i]);
        }

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        Dv[start] = 0;
        pq.add(new Node(start, 0)); //가중치가 가장 작은 것은 자기 자신으로 돌아올 때.

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(!Vv[now.end])
                Vv[now.end] = true;

            for(Node next : array[now.end]) {
                if(!Vv[next.end] && Dv[next.end] > now.w + next.w) {
                    Dv[next.end] = now.w + next.w;
                    pq.add(new Node(next.end, Dv[next.end]));
                }
            }
        }
    }

    static class Node {
        int end;    //도착노드
        int w;      //가중치

        public Node(int end, int w){
            this.end = end;
            this.w = w;
        }
    }

}

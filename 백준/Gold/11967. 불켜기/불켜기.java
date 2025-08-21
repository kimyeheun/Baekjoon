import java.io.*;
import java.util.*;


class Main {

    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int N;
    static boolean[][] visited;
    static boolean[][] map;
    static Queue<Node> queue;
    static List<Node> candidates;

    static class Node {
        int n;
        int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }
        @Override
        public int hashCode() {
            return Objects.hash(n );
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null  || o.getClass() != getClass()) return false;
            Node n = (Node) o;
            return this.n == n.n && this.m == n.m;
        }

        @Override
        public String toString() {
            return n + " " + m;
        }
    }

    public static void checkNearBy() {
        for(Node node : candidates) {
            int n = node.n;
            int m = node.m;

            if (visited[n][m] || !map[n][m]) continue;

            for(int[] mv : move) {
                int nextn = n + mv[0];
                int nextm = m + mv[1];
                if (nextn < 0 || nextm < 0 || nextn >= N || nextm >= N) continue;
                // 불이 켜진 곳과 연결되어있고 방문하지 않은 곳이다!
                if (visited[nextn][nextm]) {
                    queue.add(new Node(n, m));
                    visited[n][m] = true;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * bfs, 인접 리스트
         * 불을 켤 수 있는 방의 개수!
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트
        Map<Node, List<Node>> nodes = new HashMap<>();
        map = new boolean[N][N];
        visited = new boolean[N][N];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            Node now = new Node(x, y);
            if (!nodes.containsKey(now)) {
                nodes.put(now, new ArrayList<>());
            }
            nodes.get(now).add(new Node(a, b));
        }

        candidates = new ArrayList<>();
        queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        map[0][0] = true;
        visited[0][0] = true;
        candidates.add(new Node(0,0));

        /**
         * 1. 지금 위치에서 켤 수 있는 방 불 켜기
         * 2. 일단 모든 켜진 방을 리스트에 넣기
         * 3. 리스트 (후보방 - 실제 방문 할 가능성이 있는 리스트) 의 방이 불 켜진 곳과 연결된 곳인지 판단
         * 4. 맞 닿아있다면 queue(큐에 넣을 때는 visit 처리) 에 넣음
         */
        // map 불 켜기
        while(!queue.isEmpty()) {
            Node now = queue.remove();

            // 불켜진 방에서 켤 수 있는 방의 불을 모두 켬
            if (nodes.containsKey(now)) {
                for(Node next : nodes.get(now)) {
                    if (map[next.n][next.m]) continue;

                    map[next.n][next.m] = true;
                    candidates.add(new Node(next.n, next.m));
                }
            }
            // 후보 방 돌아다니면서 불 켜진 곳과 연결되어있는지 확인
            checkNearBy();
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (map[i][j]) result += 1;
            }
        }

        System.out.println(result);
    }
}
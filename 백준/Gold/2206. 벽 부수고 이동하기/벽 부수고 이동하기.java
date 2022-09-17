import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visit;
    static Queue<int[]> go = new LinkedList<>();
    static Queue<int[]> change = new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static int[] mx = {0, 0, -1, 1};
    static int[] my = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] buf = br.readLine().split(" ");
        N = Integer.parseInt(buf[0]);
        M = Integer.parseInt(buf[1]);

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            buf = br.readLine().split("");
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(buf[m]);
                if(map[n][m] == 1) {
                    map[n][m] = -1;
                    change.add(new int[] {n, m});
                }
            }
        }

        System.out.println(go());



    }

    public static int bfs() {
        while(!go.isEmpty()) {
            int a = go.peek()[0];
            int b = go.poll()[1];
            visit[a][b] = true;

            for (int i = 0; i < 4; i++) {
                int na = a + mx[i];
                int nb = b + my[i];

                if(na >= 0 && nb >= 0 && na < N && nb < M) {
                    if(map[na][nb] != -1 && !visit[na][nb]) {
                        visit[na][nb] = true;
                        go.add(new int[]{na, nb});
                        map[na][nb] = map[a][b] + 1;
                        if(na == N -1 && nb == M -1) {
                            return map[N-1][M-1];
                        }
                    }
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        } System.out.println();

        return 0;

    }

    public static int go() {
        Queue<Node> q = new ArrayDeque<>();

        Node node = new Node(0, 0, false, 1);
        q.offer(node);
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;

        while (!q.isEmpty()){
            Node now = q.poll();
            if(now.y == N - 1 && now.x == M - 1) return now.cnt;

            for (int i = 0; i < 4; i++) {
                int ny = now.y + my[i];
                int nx = now.x + mx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M){
                    if (map[ny][nx] == 0 && !visited[ny][nx][btoi(now.flag)]) {
                        q.offer(new Node(ny, nx, now.flag, now.cnt + 1));
                        visited[ny][nx][btoi(now.flag)] = true;
                    } else {
                        if (!now.flag && !visited[ny][nx][1]) {
                            q.offer(new Node(ny, nx, true, now.cnt + 1));
                            visited[ny][nx][1] = true;
                        }
                    }

                }
            }
        }
        return -1;
    }

    static int btoi(boolean b){
        return b ? 1: 0;
    }

    static class Node{
        int y;
        int x;
        boolean flag;
        int cnt;

        public Node(int y, int x, boolean flag, int cnt){
            this.y = y;
            this.x = x;
            this.flag = flag;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", flag=" + flag +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}

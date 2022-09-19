import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
    static int N, M;
    static Queue<Tomato> ripe = new ArrayDeque<>();
    static int[][] map;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
                if(map[n][m] == 1) {
                    ripe.add(new Tomato(n, m));
                }

            }
        }

        bfs();
        System.out.println(check());
    }

    private static int check() {
        int max = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if(map[n][m] == 0)
                    return -1;
                max = Math.max(max, map[n][m]);
            }
        }
        if(max == 1)
            return 0;
        return max - 1;
    }


    public static void bfs() {
        while(!ripe.isEmpty()) {
            Tomato now = ripe.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + mx[i];
                int ny = y + my[i];

                if(nx < 0 | ny < 0 | nx >= N | ny >= M)
                    continue;

                if(map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y] +1;
                    ripe.add(new Tomato(nx, ny));
                }
            }
        }
    }


    static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

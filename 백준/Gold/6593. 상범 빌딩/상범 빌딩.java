import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int H, N, M; //높이, 세로, 가로
    static char[][][] map;
    static int[][][] go;
    static Queue<Build> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[H][N][M];
            go = new int[H][N][M];
            q = new ArrayDeque<>();
            
            if(H == 0 && N == 0 && M == 0)
                break;

            for (int h = 0; h < H; h++) {
                for (int n = 0; n < N; n++) {
                    String[] line = br.readLine().split("");
                    for (int m = 0; m < M; m++) {
                        map[h][n][m] = line[m].charAt(0);
                        if(map[h][n][m] == 'S') {
                            q.add(new Build(h, n, m));
                            go[h][n][m] = 0;
                        }
                    }
                }
                br.readLine();
            }

            System.out.println(bfs());
        }

    }

    public static String bfs() {
        int[] mh = {-1, 1, 0, 0, 0, 0};
        int[] my = {0, 0, -1, 1, 0, 0};
        int[] mx = {0, 0, 0, 0, -1, 1};

        while(!q.isEmpty()) {
            Build now = q.poll();
            int h = now.h;
            int y = now.y;
            int x = now.x;

            for (int i = 0; i < 6; i++) {
                int nh = h + mh[i];
                int ny = y + my[i];
                int nx = x + mx[i];

                if(nh < 0 | ny < 0 | nx < 0 | nh >= H | ny >= N | nx >= M)
                    continue;
                if(map[nh][ny][nx] == '#')
                    continue;

                if(map[nh][ny][nx] == '.' && go[nh][ny][nx] == 0) {
                    q.add(new Build(nh, ny, nx));
                    go[nh][ny][nx] = go[h][y][x] + 1;
                }

                if(map[nh][ny][nx] == 'E' && go[nh][ny][nx] == 0) {
                    return "Escaped in " + (go[h][y][x] + 1) + " minute(s).";
                }
            }
        }
        return "Trapped!";
    }


    static class Build {
        int h;
        int y;
        int x;

        public Build(int h, int y, int x) {
            this.h = h;
            this.y = y;
            this.x = x;
        }
    }

}

import java.util.*;

public class Main {
    static int N, M, H;
    static Queue<int[]> tomato = new LinkedList<>();
    static int[] move_x = {-1, 1, 0, 0, 0, 0};
    static int[] move_y = {0, 0, -1, 1, 0, 0};
    static int[] move_z = {0, 0, 0, 0, -1, 1};

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        int[][][] boxes = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    boxes[h][n][m] = sc.nextInt();
                    if(boxes[h][n][m] == 1) {
                        tomato.add(new int[] {h, n, m});
                    }
                }
            }
        }

        System.out.println(bfs(boxes));
    }

    public static int bfs(int[][][] boxes) {
        while(!tomato.isEmpty()) {
            int[] buf = tomato.poll();
            int x = buf[2]; //m
            int y = buf[1]; //n
            int z = buf[0]; //h

            for(int i = 0; i < 6; i++) {
                int next_x = x + move_x[i];
                int next_y = y + move_y[i];
                int next_h = z + move_z[i];
                if(next_x < 0 | next_y < 0 | next_h < 0 | next_x >= M | next_y >= N | next_h >= H)
                    continue;
                if(boxes[next_h][next_y][next_x] == 0) {
                    boxes[next_h][next_y][next_x] = boxes[z][y][x] + 1;
                    tomato.add(new int[] {next_h, next_y, next_x});
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if(boxes[h][n][m] == 0)
                         return -1;
                    ans = Math.max(ans, boxes[h][n][m]);
                }
            }
        }
        if(ans == 1)
            return 0;
        else
            return ans -1;
    }
}
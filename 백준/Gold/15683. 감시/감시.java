import java.util.*;

public class Main {
    static int N, M, minBlindSpot = Integer.MAX_VALUE;
    static int[][] office;
    static List<int[]> cctvs = new ArrayList<>();
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우, 하, 좌, 상
    static int[][][] cctvModes = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                office[i][j] = sc.nextInt();
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, office[i][j]});
                }
            }
        }

        dfs(0, office);
        System.out.println(minBlindSpot);
        sc.close();
    }

    static void dfs(int depth, int[][] map) {
        if (depth == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, countBlindSpot(map));
            return;
        }

        int[][] backup = new int[N][M];
        int[] cctv = cctvs.get(depth);
        int x = cctv[0], y = cctv[1], type = cctv[2];

        for (int[] mode : cctvModes[type]) {
            copyMap(map, backup);
            markArea(map, x, y, mode);
            dfs(depth + 1, map);
            copyMap(backup, map);
        }
    }

    static void markArea(int[][] map, int x, int y, int[] mode) {
        for (int d : mode) {
            int nx = x, ny = y;
            while (true) {
                nx += directions[d][0];
                ny += directions[d][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) break;
                if (map[nx][ny] == 0) map[nx][ny] = -1;
            }
        }
    }

    static int countBlindSpot(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    static void copyMap(int[][] src, int[][] dest) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, M);
        }
    }
}
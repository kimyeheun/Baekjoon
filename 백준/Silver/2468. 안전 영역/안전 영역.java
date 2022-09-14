import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] wet; //default false
    static Queue<int[]> find = new LinkedList<>();
    static int n;
    static int area;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        int rain_max = 0;

        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            for(int u = 0; u < n; u++) {
                map[i][u] = Integer.parseInt(line[u]);
                if(rain_max < map[i][u])
                    rain_max = map[i][u];
            }
        }
        int max = 0;

        for(int rain = 0; rain < rain_max; rain++) {
            area = 0;
            wet = new boolean[n][n];

            raining(rain);

            if(max < area)
                max = area;
        }
        System.out.println(max);
    }

    public static void raining(int rain) {
        for (int i = 0; i < n; i++) {
            for (int u = 0; u < n; u++) {
                if (map[i][u] > rain && !wet[i][u]) {
                    bfs(i, u, rain);
                    area++;
                }
            }
        }
    }

    public static void bfs(int i, int u, int rain) {
        int[] move_x = {-1, 1, 0, 0};
        int[] move_y = {0, 0, -1, 1};
        find.add(new int[] {i, u});
        wet[i][u] = true;

        while(!find.isEmpty()) {
            int[] buf = find.poll();
            int now_x = buf[0];
            int now_y = buf[1];

            for (int a = 0; a < 4; a++) {
                int next_x = now_x + move_x[a];
                int next_y = now_y + move_y[a];

                if (next_x < 0 || next_y < 0 || next_x >= n || next_y >= n)
                    continue;
                if (map[next_x][next_y] <= rain)
                    continue;
                if (wet[next_x][next_y])
                    continue;

                wet[next_x][next_y] = true;
                find.add(new int[] {next_x, next_y});
            }
        }
    }
}







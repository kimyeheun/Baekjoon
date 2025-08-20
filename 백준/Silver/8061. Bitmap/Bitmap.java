import java.io.*;
import java.util.*;


class Main{
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n*m 비트맵에서 하얀색 간 거리를 구하여라.

        // 1부터 시작하는 bfs

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] bitmap = new int[n][m];
        char[][] visited = new char[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                bitmap[i][j] = line.charAt(j) - '0';
                if (bitmap[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int[] mv : move) {
                int nextX = now[0] + mv[0];
                int nextY = now[1] + mv[1];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (bitmap[nextX][nextY] != 0) continue;
                if (visited[nextX][nextY] == 1) continue;

                queue.add(new int[]{nextX,nextY});
                bitmap[nextX][nextY] = bitmap[now[0]][now[1]] + 1;
                visited[nextX][nextY] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append((bitmap[i][j] - 1) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
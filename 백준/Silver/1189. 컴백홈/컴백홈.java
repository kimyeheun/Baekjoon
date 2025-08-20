import java.io.*;
import java.util.*;


class Main{
    static int R;
    static int C;
    static int K;
    static int space;
    static int[][] map;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static int result = 0;

    static void backTracking(boolean[][] visited, int[] now, int dist, int go) {
        if (dist > K) return;
        if (now[0] == 0 && now[1] == C-1) {
            result = dist == K ? result + 1 : result;
            return;
        }
        if (go == space) return;

        for(int[] mv : move) {
            int next0 = now[0] + mv[0];
            int next1 = now[1] + mv[1];

            if (next0 < 0 ||  next1 < 0 || next0 >= R || next1 >= C) continue;
            if (visited[next0][next1]) continue;
            if (map[next0][next1] == -1) continue;

            visited[next0][next1] = true;
            backTracking(visited, new int[] {next0, next1}, dist+1, go+1);
            visited[next0][next1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        space = 0;
        for(int r = 0; r < R; r++) {
            String line = br.readLine();
            for(int c = 0; c < C; c++) {
                if (line.charAt(c) == '.') {
                    map[r][c] = 0;
                    space++;
                }
                else
                    map[r][c] = -1;
            }
        }

        boolean[][] visited = new boolean[R][C];
        visited[R-1][0] = true;
        backTracking(visited, new int[]{R-1, 0}, 1, 0);
        System.out.println(result);
    }
}
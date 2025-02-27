import java.io.*;
import java.util.*;


public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int count = 0;

    static int[][] move = {{-1,1}, {0,1}, {1,1}};

    static boolean dfs(int r, int c) {
        visited[r][c] = true;
        if (c == C - 1) return true; 

        for (int[] mv : move) {
            int nr = r + mv[0];
            int nc = c + mv[1];

            if (nr >= 0 && nr < R && nc < C && !visited[nr][nc] && map[nr][nc] == '.') {
                if (dfs(nr, nc)) return true;  
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) count++;  
        }

        System.out.println(count);
    }
}

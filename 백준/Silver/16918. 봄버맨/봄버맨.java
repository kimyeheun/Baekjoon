import java.io.*;
import java.util.*;


class Main{
    static int R, C;
    static boolean[][] visited;
    static char[][] map;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void fill(char bomb) {
        visited = new boolean[R][C];

        for(int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == bomb && !visited[r][c]) {
                    for (int[] mv : move) {
                        int nextn = mv[0] + r;
                        int nextm = mv[1] + c;
                        if (nextn < 0 || nextm < 0 || nextn >= R || nextm >= C) continue;
                        if (map[nextn][nextm] == bomb) continue;
                        map[nextn][nextm] = bomb;
                        visited[nextn][nextm] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        StringBuilder sb = new StringBuilder();

        // 짝수면 무조건 O
        if (N % 2 == 0) {
            for(int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    sb.append("O");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }

        for(int r = 0; r < R; r++) {
            String line = br.readLine();
            for(int c = 0; c < C; c++) {
                if (line.charAt(c) == 'O') {
                    map[r][c] = 'O';
                }
                else map[r][c] = '.';
            }
        }

        if (N == 1) {
            for(int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    sb.append(map[r][c]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }

        fill('O');
        if ((N / 2) % 2 != 0) {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    sb.append(map[r][c] == 'O' ? '.' : 'O');
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }
        fill('.');
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
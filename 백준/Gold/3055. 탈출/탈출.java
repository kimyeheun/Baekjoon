import java.io.*;
import java.util.*;

public class Main {

    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static class XY {
        int n;
        int m;

        XY(int n, int m) {
            this.n = n;
            this.m = m;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + m;
            result = prime * result + n;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            XY other = (XY) obj;
            return m == other.m && n == other.n;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<XY> queue = new LinkedList<>();
        Queue<XY> water = new LinkedList<>();

        char[][] map = new char[N][M];
        int[][] flood = new int[N][M];
        int[][] go = new int[N][M];
        boolean[][] waterVisited = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];

        int endN = 0;
        int endM = 0;

        for(int n = 0; n < N; n++) {
            String line = br.readLine();
            for(int m = 0; m < M; m++) {
                map[n][m] = line.charAt(m);
                if(map[n][m] == 'S') {
                    queue.add(new XY(n, m));
                    visited[n][m] = true;
                    go[n][m] = 0;
                }
                else if (map[n][m] == '*') {
                    water.add(new XY(n, m));
                    waterVisited[n][m] = true;
                    flood[n][m] = 0;
                }
                else if (map[n][m] == 'D') {
                    endN = n;
                    endM = m;
                }
            }
        }

        while(!water.isEmpty()) {
            XY now = water.poll();

            for(int[] mv : move) {
                int nextn = now.n + mv[0];
                int nextm = now.m + mv[1];

                if (nextn < 0 || nextm < 0 || nextn >= N || nextm >= M) continue;
                if (!waterVisited[nextn][nextm] && map[nextn][nextm] == '.') {
                    flood[nextn][nextm] = flood[now.n][now.m] + 1;
                    waterVisited[nextn][nextm] = true;
                    water.add(new XY(nextn, nextm));
                }
            }
        }

        while(!queue.isEmpty()) {
            XY now = queue.poll();

            for(int[] mv : move) {
                int nextn = now.n + mv[0];
                int nextm = now.m + mv[1];

                if (nextn < 0 || nextm < 0 || nextn >= N || nextm >= M) continue;
                else if (!visited[nextn][nextm] &&
                        (map[nextn][nextm] == '.' || map[nextn][nextm] == 'D') &&
                        (flood[nextn][nextm] > go[now.n][now.m] + 1 || flood[nextn][nextm] == 0)) {
                    go[nextn][nextm] = go[now.n][now.m] + 1;
                    visited[nextn][nextm] = true;
                    queue.add(new XY(nextn, nextm));
                }
            }
        }

        if (go[endN][endM] > 0) System.out.println(go[endN][endM]);
        else System.out.println("KAKTUS");
    }
}
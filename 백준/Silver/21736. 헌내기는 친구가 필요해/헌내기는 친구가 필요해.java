import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int M;
    static char[][] map;
    static int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static boolean[][] visited;
    static int result = 0;

    static void bfs(int n, int m) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{n,m});

        while (!stack.isEmpty()) {
            int[] now = stack.pop();
            int nown = now[0];
            int nowm = now[1];

            for(int[] mv : move) {
                int nextn = nown + mv[0];
                int nextm = nowm + mv[1];

                if(nextn < 0 || nextn >= N || nextm < 0 || nextm >= M)
                    continue;
                if (visited[nextn][nextm] || map[nextn][nextm] == 'X')
                    continue;

                if (map[nextn][nextm] == 'P') result++;
                stack.add(new int[] {nextn, nextm});
                visited[nextn][nextm] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        int s = 0;
        int e = 0;
        for(int n = 0; n < N; n++) {
            String line = br.readLine();
            for(int m = 0; m < M; m++) {
                map[n][m] = line.charAt(m);
                if (map[n][m] == 'I') {
                    s = n;
                    e = m;
                }
            }
        }

        bfs(s, e);

        if (result == 0) System.out.println("TT");
        else System.out.println(result);

    }
}

import java.util.*;

public class Main {
    static int[][] link = new int[101][101];
    static boolean[] visit;
    static int N;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            link[x][y] = link[y][x] = 1;
        }
        visit = new boolean[N+1];

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;

        queue.add(1);
        visit[1] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 1; i <= N; i++) {
                if(!visit[i] && link[now][i] == 1) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            if(visit[i]) {
                ans++;
            }
        }
        return ans - 1;
    }
}
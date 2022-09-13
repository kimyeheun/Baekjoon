import java.util.*;

public class Main {
    static int N;
    static int[][] dfsb= new int[1001][1001]; //간선 배열
    static boolean[] visit; //노드 방문 확인

    static Queue<Integer> queue = new LinkedList<>();

    public static void dfs(int v) {
        System.out.print(v+" ");
        visit[v] = true;

        int i;
        for(i = 1; i <=N; i++) {
            if (!visit[i] && dfsb[v][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        queue.add(v);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            visit[now] = true;
            System.out.print(now + " ");

            for(int i = 1; i <= N; i++) {
                if(!visit[i] && dfsb[now][i] == 1) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N= sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        visit = new boolean[N+1];

        for(int i = 1; i <= M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            dfsb[x][y] = dfsb[y][x] = 1; //양방향 간선 연결
        }

        dfs(V);

        System.out.println();
        visit = new boolean[N+1];

        bfs(V);
    }
}


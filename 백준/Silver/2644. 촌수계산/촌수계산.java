import java.util.*;

public class Main {
    static int[][] relation = new int[101][101];
    static int[] visit;
    static int N;
    static int count = 0;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            relation[x][y] = relation[y][x] = 1;
        }
        
        visit = new int[N+1];

        dfs(p1, p2);
        
        if(visit[p2] == 0) 
            visit[p2] = -1;

        System.out.println(visit[p2]);
    }

    public static void dfs(int now, int end) {
        for(int i = 1; i <= N; i++) {
            if (visit[i] == 0 && relation[now][i] == 1) {
                visit[i] = visit[now] + 1;
                dfs(i, end);
            }
        }
    }
}


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
        int count = 0;

        dfs(1);

        for(int i = 1; i <= N; i++) {
            if(visit[i])
                count++;
        }
        System.out.println(count - 1);
    }

    public static void dfs(int now) {
        for(int i = 1; i <= N; i++) {
            if(!visit[i] && link[now][i] == 1) {
                visit[i] = true;
                dfs(i);
            }
        }
    }

}


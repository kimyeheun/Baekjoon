import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nandm = sc.nextLine().split(" ");
        int N = Integer.parseInt(nandm[0]);
        int M = Integer.parseInt(nandm[1]);
        Queue<int[]> path = new LinkedList<>();

        int[] way = {-1, 1, 0, 0};
        int[][] maze = new int[N+1][M+1];

        for(int i =1; i <= N; i++) {
            String[] line = sc.nextLine().split("");
            for(int u = 1; u <= M; u++) {
                maze[i][u] = Integer.parseInt(line[u-1]);
            }
        }
        maze[1][1] = 2;
        path.add(new int[] {1,1});

        while(!path.isEmpty()) {
            int[] now = path.poll();
            int n = now[0];
            int m = now[1];

            for(int u = 0; u < way.length; u++) {
                int n_n = n + way[u];
                int n_m = m + way[3-u];

                if(n_n < 1 || n_n > N || n_m < 1 || n_m > M)
                    continue;
                if(maze[n_n][n_m] != 1)
                    continue;

                path.add(new int[] {n_n, n_m});
                maze[n_n][n_m] = maze[n][m] + 1;
            }
        }
        System.out.println(maze[N][M]-1);

    }
}

//[풀이]
//1. bfs 문제임. 냅다 큐 만들어
//2. 이차원 배열 만들고 벽, 길 저장
//3. 시작 좌표는 1,1 값은 2로 지정한다.
//4. 임시 저장장소 now에 좌표 저장하고 next 좌표를 구함. 상하좌우
//5. 상하좌우에 길이 있는지(1이면) 확인하고 있으면 큐에 저장. 후, 1을 전 단계에 +1 한다.
//6. 큐가 빌 때까지 반복.
//6. 마지막 N,M의 값에 -1 한값 출력. 
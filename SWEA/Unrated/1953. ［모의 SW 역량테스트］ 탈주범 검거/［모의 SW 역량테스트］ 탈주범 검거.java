import java.util.*;
import java.io.*;


public class Solution {
    static int[] di = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dj = {0, 0, -1, 1};
    static boolean[][] type = {
            {true, true, true, true},  // 상하좌우
            {true, true, false, false},  // 상 하
            {false, false, true, true},  // 좌 우
            {true, false, false, true},  // 상 우
            {false, true, false, true},  // 하 우
            {false, true, true, false},  // 하 좌
            {true, false, true, false}   // 상 좌
    };

    public static class XY {
        int i;
        int j;
        int type;

        public XY(int i, int j, int type) {
            this.i = i;
            this.j = j;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 세로
            int M = Integer.parseInt(st.nextToken()); // 가로
            int R = Integer.parseInt(st.nextToken()); // 맨홀 세로
            int C = Integer.parseInt(st.nextToken()); // 맨홀 가로
            int L = Integer.parseInt(st.nextToken()); // 소요 시간

            // 맵 초기화
            int[][] map = new int[N][M];
            boolean[][] go = new boolean[N][M];

            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[n][m] = Integer.parseInt(st.nextToken());
                    go[n][m] = false;
                }
            }

            // 스택 초기화
            Queue<XY> queue = new LinkedList<>();
            queue.add(new XY(R, C, map[R][C]));
            go[R][C] = true;

            // BFS 진행
            // 중단 조건 : 스택이 비었을 때 or  L이 되었을 때
            int time = 1;
            int i;
            while(!queue.isEmpty()) {
                if (time >= L) break;

                int size = queue.size();
                for (int s = 0; s < size; s++) {
                    i = 0;
                    XY now = queue.remove();
                    for (boolean b : type[now.type - 1]) {
                        if (b) {
                            int next_i = now.i + di[i];
                            int next_j = now.j + dj[i];
                            // 다음 위치가 유용한지 확인하고 저장
                            // 범위 확인
                            if (next_i >= 0 && next_i < N && next_j >= 0 && next_j < M) {
                                // 방문 안 한 곳 + 파이프 있는 곳
                                if (!go[next_i][next_j] && map[next_i][next_j] != 0) {
                                    // 다음 파이프의 방향 확인
                                    int way;
                                    if (i < 2) way = (i == 0) ? 1 : 0;
                                    else way = (i == 3) ? 2 : 3;
                                    if (type[map[next_i][next_j] - 1][way]) {
                                        queue.add(new XY(next_i, next_j, map[next_i][next_j]));
                                        go[next_i][next_j] = true;
                                    }
                                }
                            }
                        }
                        i++;
                    }
                }
                time++;
            }

            int result = 0;
            for(int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (go[n][m])
                        result += 1;
                }
            }
            System.out.println("#" + test + " " + result);
        }
    }
}

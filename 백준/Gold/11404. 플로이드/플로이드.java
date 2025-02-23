import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];

        // 맵 초기화
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            map[x][y] = Math.min(map[x][y], num);
        }

        for(int i = 1; i <= N; i++) {
            for(int s = 1; s <= N; s++) {
                for(int e = 1; e <= N; e++) {
                    if (map[s][i] == Integer.MAX_VALUE || map[i][e] == Integer.MAX_VALUE) continue;
                    map[s][e] = Math.min(map[s][e], map[s][i] + map[i][e]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(map[i][j] == Integer.MAX_VALUE) sb.append(0);
                else sb.append(map[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
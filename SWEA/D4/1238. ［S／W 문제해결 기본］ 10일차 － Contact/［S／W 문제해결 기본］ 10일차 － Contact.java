import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N;
    static int start;
    static int[][] map;
    static int[] visited;

    private static int bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        int cnt = 1;
        visited[v] = cnt;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=1; i <= 100; i++){
                if(map[now][i] == 1 && visited[i] == 0){
                    queue.add(i);
                    visited[i] = visited[now]+1;
                }
            }
            cnt = Math.max(cnt,visited[now]);
        }

        for(int i=100; i>=0; i--) {
            if(visited[i] == cnt) return i;
        }

        return -1;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            map = new int[101][101];
            visited = new int[101];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                map[s][e] = 1;
            }
            int result = bfs(start);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
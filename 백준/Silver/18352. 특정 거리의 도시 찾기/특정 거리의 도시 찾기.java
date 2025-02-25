import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시

        Map<Integer, List<int[]>> roads = new HashMap<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<int[]> buf = roads.getOrDefault(s, new ArrayList<>());
            buf.add(new int[] {s, e});
            roads.put(s, buf);
        }

        int[] minDist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[X] = 0;
        visited[X] = true;
        Queue<int[]> queue = new LinkedList<>(roads.get(X));

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if (!visited[now[1]]) {
                minDist[now[1]] = Math.min(minDist[now[1]], minDist[now[0]] + 1);
                visited[now[1]] = true;
                if (roads.get(now[1]) != null)
                    queue.addAll(roads.get(now[1]));
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean isAns = false;
        for(int i = 0; i <= N; i++) {
            if(minDist[i] == K) {
                sb.append(i).append("\n");
                isAns = true;
            }
        }
        if (!isAns) sb.append(-1);
        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] peoples;
    static boolean[][] connected;
    static int result = Integer.MAX_VALUE;

    static int countPeople(boolean[] nodes) {
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 1; i <= N; i++) {
            if (nodes[i]) cnt1 += peoples[i];
            else cnt2 += peoples[i];
        }
        return Math.abs(cnt1 - cnt2);
    }

    static boolean isConnected(boolean[] nodes, int num) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int tc = 1;
        // true 그룹 연결 확인
        for(int i =1; i <= N; i++) {
            if (nodes[i]) {
                queue.add(i);
                visited[i] = true;
                break;
            }
        }
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i <= N; i++) {
                if(connected[now][i] && !visited[i] && nodes[i]) {
                    queue.add(i);
                    visited[i] = true;
                    tc++;
                }
            }
        }

        // false 그룹 연결 확인
        int fc = 1;
        visited = new boolean[N+1];
        for(int i =1; i <= N; i++) {
            if (!nodes[i]) {
                queue.add(i);
                visited[i] = true;
                break;
            }
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i <= N; i++) {
                if(connected[now][i] && !visited[i] && !nodes[i]) {
                    queue.add(i);
                    visited[i] = true;
                    fc++;
                }
            }
        }
        return (tc == num && fc == (N-num));
    }

    // num : 특정 구역의 개수 | cnt : 특정 구역의 현재 개수
    static void Area(int num, int cnt, int idx, boolean[] nodes) {
        if (num == cnt) {
            if (isConnected(nodes, num)) {
                int buf = countPeople(nodes);
                result = Math.min(buf, result);
            }
            return;
        }
        if(idx > N) return;

        nodes[idx] = true;
        Area(num, cnt+1, idx+1, nodes);
        nodes[idx] = false;

        Area(num, cnt, idx+1, nodes);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        peoples = new int[N+1];
        connected = new boolean[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            peoples[n] = Integer.parseInt(st.nextToken());
        }

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            int nums = Integer.parseInt(st.nextToken());
            for(int i = 0; i < nums; i++) {
                int node = Integer.parseInt(st.nextToken());
                connected[n][node] = true;
                connected[node][n] = true;
            }
        }

        // 구역 나누기 (조합)
        for(int i = 1; i < N; i++) {
            Area(i, 0, 1, new boolean[N+1]);
        }
        // 구역 연결 확인하기 (bfs)

        // 인구 수 최솟값 계산하기
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }
}
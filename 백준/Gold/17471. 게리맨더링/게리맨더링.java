import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static List<Integer>[] adjList;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N];
        adjList = new ArrayList[N];
        selected = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            adjList[i] = new ArrayList<>();
        }

        // 인접 리스트 구성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int neighbor = Integer.parseInt(st.nextToken()) - 1;
                adjList[i].add(neighbor);
            }
        }

        // 부분 집합을 이용해 두 개의 선거구 나누기
        subset(0);
        
        // 조건에 맞는 선거구를 찾지 못한 경우 -1 출력
        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }

    // 모든 부분 집합을 만들면서 그룹을 나누는 재귀 함수
    static void subset(int idx) {
        if (idx == N) {
            // 두 개의 그룹이 모두 비어있지 않은지 확인
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (selected[i]) groupA.add(i);
                else groupB.add(i);
            }

            if (groupA.isEmpty() || groupB.isEmpty()) return;

            // 두 그룹이 각각 연결되어 있는지 확인
            if (isConnected(groupA) && isConnected(groupB)) {
                // 인구 차이 계산
                int sumA = 0, sumB = 0;
                for (int i : groupA) sumA += population[i];
                for (int i : groupB) sumB += population[i];
                minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
            }
            return;
        }

        // 현재 idx를 그룹 A에 포함
        selected[idx] = true;
        subset(idx + 1);

        // 현재 idx를 그룹 B에 포함
        selected[idx] = false;
        subset(idx + 1);
    }

    // BFS를 사용하여 해당 그룹이 연결되어 있는지 확인
    static boolean isConnected(List<Integer> group) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(group.get(0));
        visited[group.get(0)] = true;

        int count = 1; // 방문한 노드 수
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : adjList[now]) {
                if (!visited[next] && group.contains(next)) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count == group.size();
    }
}

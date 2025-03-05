import java.util.*;
import java.io.*;

public class Main {
    static int[] parents;

    static class Route implements Comparable<Route> {
        int s;
        int e;
        int w;

        Route(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Route other) {
            return this.w - other.w;
        }
        @Override
        public String toString() {
            return "[" + this.s + ", " + this.e + ", " + this.w + "]";
        }
    }

    static int find(int idx) {
        if (parents[idx] == idx) return idx;
        return parents[idx] = find(parents[idx]);
    }

    static void merge(int idx1, int idx2) {
        int p1 = find(idx1);
        int p2 = find(idx2);

        if(p1 < p2) parents[p2] = p1;
        else parents[p1] = p2;
    }

    static boolean isUnion(int idx1, int idx2) {
        return find(idx1) == find(idx2);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 부모 노드 배열 초기화
        parents = new int[N];
        for(int i = 0; i < N; i++) parents[i] = i;

        // 우선순위 큐
        PriorityQueue<Route> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int buf =  Integer.parseInt(st.nextToken());
                if (j >= i) pq.add(new Route(i, j, buf));
            }
        }

        // mst 계산
        long cost = 0;
        while(!pq.isEmpty()) {
            Route now = pq.poll();
            int n1 = now.s;
            int n2 = now.e;

            if (isUnion(n1, n2)) continue;
            cost += now.w;

            merge(n1, n2);
        }

        System.out.println(cost);
    }
}

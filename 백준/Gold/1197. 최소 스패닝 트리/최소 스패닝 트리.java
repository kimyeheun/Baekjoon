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
    }

    static int find(int idx) {
        if (parents[idx] == idx)
            return idx;
        return parents[idx] = find(parents[idx]);
    }

    static void merge(int idx1, int idx2) {
        int p1 = find(idx1);
        int p2 = find(idx2);

        if (p1 > p2) parents[p1] = p2;
        else parents[p2] = p1;
    }

    static boolean isUnion(int idx1, int idx2) {
        return find(idx1) == find(idx2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Route> pq = new PriorityQueue<>();

        parents = new int[V+1];
        for(int i = 1; i <= V; i++)
            parents[i] = i;

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Route(s, end, w));
        }

        int result = 0;
        while(!pq.isEmpty()) {
            Route now = pq.poll();
            int n1 = now.s;
            int n2 = now.e;

            if (isUnion(n1, n2)) continue;

            result += now.w;
            merge(n1, n2);
        }

        System.out.println(result);
    }
}

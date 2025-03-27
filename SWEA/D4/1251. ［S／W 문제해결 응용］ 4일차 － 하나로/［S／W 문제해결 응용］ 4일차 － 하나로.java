import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    static int[] parents;

    public static boolean union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if (p1 != p2) {
            parents[p2] = p1;
            return true;
        }
        return false;
    }

    public static int find(int a) {
        if (parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] nodes = new int[n][2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nodes[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nodes[i][1] = Integer.parseInt(st.nextToken());
            }

            double e = Double.parseDouble(br.readLine());
            List<double[]> routes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double dist = Math.pow(nodes[i][0] - nodes[j][0], 2) +
                            Math.pow(nodes[i][1] - nodes[j][1], 2);
                    routes.add(new double[]{i, j, dist});
                }
            }
            parents = IntStream.range(0, n).toArray();
            routes.sort(Comparator.comparingDouble(o -> o[2]));

            int cnt = 0;
            double result = 0;

            for (double[] route : routes) {
                if (union((int) route[0], (int) route[1])) {
                    result += route[2];
                    if (++cnt == n - 1) break;
                }
            }
            sb.append("#" + t + " " + Math.round(result * e) + "\n");
        }
        System.out.println(sb);
    }
}

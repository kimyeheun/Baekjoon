import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
        static int[] check;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] floor = br.readLine().split(" ");

        int F = Integer.parseInt(floor[0]);
        int S = Integer.parseInt(floor[1]);
        int G = Integer.parseInt(floor[2]);
        int U = Integer.parseInt(floor[3]);
        int D = Integer.parseInt(floor[4]);
        check = new int[F + 1];
        System.out.println(BFS(F, S, G, U, D));

    }

    public static String BFS(int Floor, int start, int go, int up, int down) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(start);
        check[start] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == go) {
                return String.valueOf(check[current] - 1);
            }
            if (current + up <= Floor) {
                if (check[current + up] == 0) {
                    check[current + up] = check[current] + 1;
                    q.add(current + up);
                }

            }
            if (current - down > 0) {
                if (check[current - down] == 0) {
                    check[current - down] = check[current] + 1;
                    q.add(current - down);
                }
            }
        }
        return "use the stairs";
    }
}

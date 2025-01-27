import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int r;
    static int c;

    static int[][] map;
    static int result = 0;

    static int find_visit(int visit, int n, int i, int j) {
        if (n == 0) {
            if (i == r && j == c)
                result = visit;
            else if (i == r && j+1 == c)
                result = visit+1;
            else if (i+1 == r && j == c)
                result = visit+2;
            else if (i+1 == r && j+1 == c)
                result = visit+3;
            return visit+4;
        }

        int nn = (int) Math.pow(2, n + 1)/2;
        int[][] move = {{0, 0}, {0, nn}, {nn, 0}, {nn, nn}};
        int idx = 0;
        for (int[] m : move) {
            visit += (Math.pow(nn, 2) * idx);
            if (r >= i + m[0] && r < i + m[0]+ nn && c >= j + m[1] && c < j + m[1] + nn) {
                find_visit(visit, n - 1, i + m[0], j + m[1]);
            }
            idx = 1;
        }

        return visit;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[2][2];
        find_visit(0, N-1, 0, 0);

        System.out.println(result);
    }
}

import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 마지막 N개의 구역을 모두 1로 만들려면?
            if ((M & ((1 << N) - 1)) == ((1 << N)  - 1))
                System.out.println("#" + t + " ON");
            else
                System.out.println("#" + t + " OFF");
        }
    }
}

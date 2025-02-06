import java.io.*;
import java.util.*;

import static java.lang.Integer.compare;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 방법 1
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                Comparator.comparingInt((Integer x) -> Math.abs(x))
                        .thenComparingInt(x -> x));
        // 방법 2
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(
                (a, b) ->
                        (Math.abs(a) == Math.abs(b)) ?
                                a - b : Math.abs(a) - Math.abs(b)
        );

        StringBuilder sb = new StringBuilder();
        for(int n = 0; n < N; n++) {
            int now = Integer.parseInt(br.readLine());
            if (now == 0) {
                if (queue2.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue2.poll()).append("\n");
            }
            else queue2.add(now);
        }

        System.out.println(sb);
    }
}

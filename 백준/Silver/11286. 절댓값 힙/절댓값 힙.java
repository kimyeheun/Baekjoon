import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                Comparator.comparingInt((Integer x) -> Math.abs(x))
                        .thenComparingInt(x -> x));

        StringBuilder sb = new StringBuilder();
        for(int n = 0; n < N; n++) {
            int now = Integer.parseInt(br.readLine());
            if (now == 0) {
                if (queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.remove()).append("\n");
            }
            else queue.add(now);
        }

        System.out.println(sb);
    }
}

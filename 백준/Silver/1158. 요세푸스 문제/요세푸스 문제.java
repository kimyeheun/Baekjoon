import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] buf = br.readLine().split(" ");
        int N = Integer.parseInt(buf[0]);
        int K = Integer.parseInt(buf[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            queue.add(i);
        }
        System.out.print("<");
        while(!queue.isEmpty()) {
            if (queue.size() == 1) {
                System.out.print(queue.remove());
            }
            else {
                for (int u = 1; u < K; u++)
                    queue.add(queue.remove());
                System.out.print(queue.remove());
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
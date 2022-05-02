import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        System.out.print("<");
        while(!queue.isEmpty()) {
            if (queue.size() == 1) {
                System.out.print(queue.remove());
            }
            else {
                for (int u = 1; u < K; u++) {
                    queue.add(queue.remove());
                }
                System.out.print(queue.remove());
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
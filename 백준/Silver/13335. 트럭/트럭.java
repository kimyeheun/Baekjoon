import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //트럭의 수
        int w = sc.nextInt(); //다리의 길이
        int L = sc.nextInt(); //다리의 최대 하중

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }

        int time = 0;
        int truck_w = 0;
        int pass = 0;

        while(pass != n) {
            time++;
            if (bridge.size() == w) {
                int a = bridge.remove();
                truck_w -= a;
                if(a != 0)
                    pass++;
            }

            if (!queue.isEmpty()) {
                if (truck_w + queue.element() <= L) {
                    bridge.offer(queue.element());
                    truck_w += queue.remove();
                } else {
                    bridge.offer(0);
                }
            } else {
                bridge.offer(0);
            }
        }
        System.out.println(time);
    }
}
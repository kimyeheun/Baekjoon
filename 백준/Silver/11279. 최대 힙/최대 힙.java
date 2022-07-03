import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < test; i++) {
            int a = sc.nextInt();
            if(a == 0) {
                if(!pq.isEmpty())
                    System.out.println(pq.remove());
                else
                    System.out.println(0);
            }
            else
                pq.add(a);
        }

    }
}

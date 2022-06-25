import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < test; i++) {
            int a = sc.nextInt();

            if(a != 0) {
                q.add(a);
            }
            else if(q.isEmpty()) {
                sb.append(0);
                sb.append("\n");
            }
            else {
                sb.append(q.poll());
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}

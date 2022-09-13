import java.util.*;

public class Main {
    static int[] hide = new int[100001];
    static int[] sec = new int[100001];
    static Queue<Integer> find = new LinkedList<>();
    static int count;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        bfs(start, end);

        System.out.println(sec[end]);
    }

    public static void bfs(int start, int end) {
        find.add(start);
        
        while(!find.isEmpty()) {
            int length = find.size();
            int now = find.poll();
            
            if (now == end)
                break;

            if (now - 1 >= 0 && sec[now - 1] == 0) {
                find.add(now - 1);
                sec[now-1] = sec[now] + 1;
            }
            if (now + 1 <= 100000 && sec[now + 1] == 0) {
                find.add(now + 1);
                sec[now+1] = sec[now] + 1;
            }
            if (now * 2 <= 100000 && sec[now * 2] == 0) {
                find.add(now * 2);
                sec[now*2] = sec[now] + 1;
            }
        }
    }
}


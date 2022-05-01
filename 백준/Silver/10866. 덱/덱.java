import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int test = Integer.parseInt(sc.readLine());
        for (int i = 0; i < test; i++) {
            String[] word = sc.readLine().split(" ");
            if (word[0].equals("push_front"))
                deque.addFirst(Integer.parseInt(word[1]));
            else if (word[0].equals("push_back"))
                deque.addLast(Integer.parseInt(word[1]));
            else if (word[0].equals("pop_front"))
                System.out.println((deque.isEmpty()) ? -1 : deque.pollFirst());
            else if (word[0].equals("pop_back"))
                System.out.println((deque.isEmpty()) ? -1 : deque.pollLast());
            else if (word[0].equals("size"))
                System.out.println(deque.size());
            else if (word[0].equals("empty"))
                System.out.println((deque.isEmpty()) ? 1 : 0);
            else if (word[0].equals("front"))
                System.out.println((deque.isEmpty()) ? -1 : deque.peekFirst());
            else if (word[0].equals("back"))
                System.out.println((deque.isEmpty()) ? -1 : deque.peekLast());
        }
    }
}

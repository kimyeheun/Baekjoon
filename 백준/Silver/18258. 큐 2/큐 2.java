import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < test; i++) {
            String[] word = br.readLine().split(" ");
            String word1 = word[0];
            if (word1.equals("push")) {
                deque.offer(Integer.parseInt(word[1]));
            }
            else if (word1.equals("pop")) {
                int a = (!deque.isEmpty()) ? deque.poll() : (-1);
                sb.append(a).append("\n");
            }
            else if (word1.equals("size"))
                sb.append(deque.size()).append("\n");
            else if (word1.equals("empty")) {
                int a = deque.isEmpty() ? 1 : 0;
                sb.append(a).append("\n");
            }
            else if (word1.equals("front")) {
                int a = !deque.isEmpty() ? deque.peek() : (-1);
                sb.append(a).append("\n");
            }
            else if (word1.equals("back")) {
                int a = !deque.isEmpty() ? deque.peekLast() : (-1);
                sb.append(a).append("\n");
            }
        }
        System.out.println(sb);
    }
}
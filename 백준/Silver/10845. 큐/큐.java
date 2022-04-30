import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int back = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < test; i++) {
            String[] word = br.readLine().split(" ");
            if (word[0].equals("push")) {
                back = Integer.parseInt(word[1]);
                queue.add(back);
            } else if (word[0].equals("pop")) {
                if (!queue.isEmpty())
                    System.out.println(queue.remove());
                else System.out.println(-1);
            } else if (word[0].equals("size"))
                System.out.println(queue.size());
            else if (word[0].equals("empty")) {
                if (queue.isEmpty())
                    System.out.println(1);
                else System.out.println(0);
            } else if (word[0].equals("front")) {
                if (!queue.isEmpty())
                    System.out.println(queue.peek());
                else System.out.println(-1);
            } else if (word[0].equals("back")) {
                if (!queue.isEmpty())
                    System.out.println(back);
                else System.out.println(-1);
            }
        }
    }
}
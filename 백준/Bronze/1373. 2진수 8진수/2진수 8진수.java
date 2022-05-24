import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num2 = br.readLine().split("");
        Deque<Integer> deque = new LinkedList<>();

        for (String s : num2) {
            deque.addLast(Integer.parseInt(s));
        }

        while(deque.size()%3 != 0) {
            deque.addFirst(0);
        }

        while (!deque.isEmpty()) {
            int sum = 0;
            Integer[] num = {1, 2, 4};
            for(int r = 0; r<3; r++) {
                if(deque.pop() == 1)
                    sum = sum + num[2-r];
            }
            System.out.print(sum);
        }
    }
}
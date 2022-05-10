import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] words = bf.readLine().split("");

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        int wc = 0;
        int w_count = 0;

        while(wc < words.length) {
            if (words[wc].equals("<") && w_count == 0) {
                while (!words[wc].equals(">")) {
                    System.out.print(words[wc]);
                    wc++;
                }
                System.out.print(">");
            }
            else {
                stack.push(words[wc]);
                w_count++;
                if (words[wc].equals(" ")) {
                    String buf = words[wc];
                    stack.pop();
                    for (int i = 0; i < w_count-1; i++) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(buf);
                    w_count = 0;
                }
                else if (words[wc].equals("<")) {
                    stack.pop();
                    for (int i = 0; i < w_count-1; i++) {
                        System.out.print(stack.pop());
                    }
                    w_count = 0;
                    wc--;
                }
                else if (wc == words.length-1) {
                    for (int i = 0; i < w_count; i++) {
                        System.out.print(stack.pop());
                    }
                    return;
                }
            }
            wc++;
        }
    }
}
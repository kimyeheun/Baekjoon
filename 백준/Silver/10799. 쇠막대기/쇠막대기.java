import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        int lay = 0;
        int index = 1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(index);
            }
            else {
                if((index - stack.peek()) == 1) {
                    stack.pop();
                    lay += stack.size();
                }
                else {
                    stack.pop();
                    lay += 1;
                }
            }
            index++;
        }
        System.out.println(lay);
    }
}

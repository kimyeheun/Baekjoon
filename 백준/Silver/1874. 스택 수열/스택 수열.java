import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        int number = sc.nextInt(); 
        int order = 0; 
        ArrayList<String> arry = new ArrayList<String>();
        
        for (int i = 0; i < number; i++) {
            int num = sc.nextInt();
            
            if (num > order) {
                for (int u = order+1; u <= num; u++) {
                    stack.push(u);
                    arry.add("+");
                }
                order = num;
            }
            
            else if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }
            
            arry.add("-");
            stack.pop();
        }
        
        for (int y = 0; y < arry.size(); y++) {
            System.out.println(arry.get(y));
        }
        
    }
}
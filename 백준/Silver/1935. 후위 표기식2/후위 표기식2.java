import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = Integer.parseInt(sc.nextLine());
        String line = sc.next();


        double[] scan = new double[test];
        for(int i = 0; i < scan.length; i++) {
            scan[i] = Double.parseDouble(sc.next());
        }
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < line.length(); i++) {
            if( 'A' <= line.charAt(i) && line.charAt(i) <= 'Z') {
                stack.push(scan[line.charAt(i) - 'A']);
            }
            else {
                if(!stack.isEmpty()) {
                    double first = stack.pop();
                    double second = stack.pop();
                    double result;
                    switch(line.charAt(i)) {
                        case '+':
                            result = second + first;
                            stack.push(result);
                            continue;
                        case '-':
                            result = second - first;
                            stack.push(result);
                            continue;
                        case '*':
                            result = second * first;
                            stack.push(result);
                            continue;
                        case '/':
                            result = second / first;
                            stack.push(result);
                    }
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}

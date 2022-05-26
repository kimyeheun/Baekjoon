import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        String[] law = sc.nextLine().split(" ");
        int first = Integer.parseInt(law[0]);
        int second = Integer.parseInt(law[1]);

        int num = Integer.parseInt(sc.nextLine());
        int sum = 0;

        String[] numbuf = sc.nextLine().split(" ");
        int[] nums = new int[num+1];

        for(int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(numbuf[i]);
            sum = sum + nums[i] * (int) Math.pow(first, num-i-1);
        }

        while (sum != 0) {
            stack.push(sum % second);
            sum = sum/second;

        }

        while(!stack.isEmpty()) {
            if(stack.size() == 1) 
                System.out.print(stack.pop());
            else 
                System.out.print(stack.pop() + " ");
        }
    }
}
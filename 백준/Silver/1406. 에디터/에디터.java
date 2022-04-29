import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int test = Integer.parseInt(br.readLine());
        Stack<Character> rightstack = new Stack<>();
        Stack<Character> leftstack = new Stack<>();
        for (int u = 0; u < word.length(); u++) {
                leftstack.push(word.charAt(u));
            }
        
        while(test-- > 0) {
            String[] line = br.readLine().split(" ");
            
            if (line[0].equals("L")) {
                if(!leftstack.empty()) 
                    rightstack.push(leftstack.pop());
            }
            else if (line[0].equals("D")) { 
                if(!rightstack.empty())
                    leftstack.push(rightstack.pop());
            }
            else if (line[0].equals("B")) {
                if(!leftstack.empty()) leftstack.pop();
            }
            else if (line[0].equals("P"))
                leftstack.push(line[1].charAt(0));
        }
        
        StringBuilder sb = new StringBuilder(); 
        while(!leftstack.isEmpty()){ rightstack.push(leftstack.pop()); }
        while(!rightstack.isEmpty()){ sb.append(rightstack.pop()); } 
        System.out.println(sb);
    }
}
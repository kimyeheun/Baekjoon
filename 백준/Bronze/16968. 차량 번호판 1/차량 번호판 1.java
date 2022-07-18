import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int num = 1;
        
        String start = s.substring(0,1);
        
        if(start.equals("c"))
            num *=26;
        else 
            num *=10;
        
        for(int i = 0; i < s.length() -1; i++) {
            String a = s.substring(i, i+1);
            String b = s.substring(i+1, i+2);
            if(a.equals("c")) {
                if(a.equals(b))
                    num *= 25;
                else 
                    num*=10;
            }
            else if(a.equals("d")) {
                if(a.equals(b))
                    num *=9;
                else 
                    num*=26;
            }
        }
        
        System.out.println(num);
    }
}
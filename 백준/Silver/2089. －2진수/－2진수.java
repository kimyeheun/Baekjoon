import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        
        if(n==0)
            System.out.println(n);
    
        while(n!=0) {
            list.add(Math.abs(n%-2));
            n=(int)Math.ceil((double)n/-2);
        }
        
        for(int i=list.size()-1; i>=0; i--)
            System.out.print(list.get(i));
    }
}
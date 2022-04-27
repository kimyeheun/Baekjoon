import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for (int u = 0; u < num; u++){
            String str = sc.next();
            String[] barcket = str.split("");
            System.out.println(problem(barcket));
        }
        
    }
    
    public static String problem(String[] bk) {
        Stack <String> block = new Stack<>();
        for (int i = 0; i < bk.length; i++) {
            if (bk[i].equals("(")) block.push("(");
            else if (block.empty()) return "NO";
            else block.pop();
        }
        if (block.empty()) return "YES";
        else return "NO";
    }
}

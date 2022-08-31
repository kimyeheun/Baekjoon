import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.next());
        int res = a;

        for(int i = 0; i < a; i++) {
            String word = sc.next();
            for(int u = 0; u < word.length(); u++) {
                int d = word.indexOf(word.charAt(u), u+1);
                if(d != -1 && d - u != 1) {
                    res -= 1;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String n = sc.next();
            if(n.equals("0"))
                break;

            String[] num = n.split("");
            String[] mun = new String[num.length];

            for (int i = num.length - 1, j = 0; i >= 0; i--, j++) {
                mun[j] = num[i];
            }

            int cnt = 0;
            for(int i = 0; i<n.length(); i++) {
                if(num[i].equals(mun[i]))
                    cnt++;
            }
            if(cnt == n.length())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc. nextInt();
        System.out.println(pibo(T));
    }
    public static int pibo(int t) {
        if (t < 2) 
            return t;
        else 
            return pibo(t-1) + pibo(t-2);
    }
}

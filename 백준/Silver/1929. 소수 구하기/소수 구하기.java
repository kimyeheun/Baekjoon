import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        int first = sc.nextInt();
        int last = sc.nextInt();
        boolean[] list = new boolean[last+1];
        Arrays.fill(list, true);   

        for(int i = 2; i<=last; i++) { 
            if (list[i]) {
                for (int j = 2; j * i <= last; j++)
                    list[j*i] = false;
            }
        }
        if (first == 1)
            list[1] = false;

        for(int u = first; u<=last; u++) {
            if(list[u]) System.out.println(u);
        }
    }
}

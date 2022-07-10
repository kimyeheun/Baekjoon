import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] p = new int[n];
        int[] r = new int[n];
        
        for(int i=0; i<n; i++) {
            p[i] = sc.nextInt();
        }
        
        Arrays.sort(p);
        r[0] = p[0];
        int sum = r[0];
        
        for(int i=1; i<n; i++){
            r[i] = r[i-1] + p[i];
            sum += r[i];
        }
        System.out.println(sum);
    }
}

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int N = sc.nextInt();
        int X = sc.nextInt();
        
        int[] arr = new int[N];
        
        for (int i = 0; i<N; i++) 
            arr[i] = sc.nextInt();
                    
        for (int y = 0; y <N; y++) {
            if(arr[y] < X)
                System.out.println(arr[y] );
        }
    }
}
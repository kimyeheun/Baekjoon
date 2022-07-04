import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        A = new int[num];
        for(int i = 0; i < num; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int nums = sc.nextInt();
        int[] number = new int[nums];

        for(int i = 0; i < nums; i++) {
            number[i] = sc.nextInt();
            System.out.println(binary(number[i], 0, num-1));
        }
    }
    static int binary(int find, int start, int fin) {
        int mid = (start + fin) / 2;

        if(start <= fin) {
            if(find == A[mid]) {
                return 1;
            }
            else if (find > A[mid]) {
                return binary(find, mid+1, fin);
            }
            else {
                return binary(find, start, mid-1);
            }
        }
        return 0;
    }
}
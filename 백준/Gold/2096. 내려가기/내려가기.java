import java.io.*;
import java.util.*;


public class Main {
    static int N;

    static int[] Max;
    static int[] Min;

    static void calc(int[] matrix) {
        int[] bufmax = new int[5];
        int[] bufmin = new int[5];
        int max, min;

        for (int j = 1; j <= 3; j++) {
            max = Math.max(Max[j-1], Max[j]);
            max = Math.max(max, Max[j+1]);

            min = Math.min(Min[j-1], Min[j]);
            min = Math.min(min, Min[j+1]);

            bufmax[j] = max + matrix[j];
            bufmin[j] = min + matrix[j];
        }

        Min = Arrays.copyOf(bufmin, bufmin.length);
        Max = Arrays.copyOf(bufmax, bufmax.length);
        Min[0] = Integer.MAX_VALUE;
        Min[4] = Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] matrix = new int[5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                matrix[j] = Integer.parseInt(st.nextToken());
            }

            if (i == 0) {
                Max = Arrays.copyOf(matrix, matrix.length);
                Min = Arrays.copyOf(matrix, matrix.length);
                Min[0] = Integer.MAX_VALUE;
                Min[4] = Integer.MAX_VALUE;            
            }
            else calc(matrix);
        }

        int result_min = Integer.MAX_VALUE-1;
        int result_max = 0;
        for (int i = 1; i <= 3; i++) {
            result_max = result_max < Max[i] ? Max[i] : result_max;
            result_min = result_min > Min[i] ? Min[i] : result_min;
        }

        System.out.println(result_max + " " + result_min);

    }
}

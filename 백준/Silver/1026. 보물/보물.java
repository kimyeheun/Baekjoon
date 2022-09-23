import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        String buf = br.readLine();
        StringTokenizer st = new StringTokenizer(buf);
        for (int j = 0; j < N; j++) {
            A[j] = Integer.parseInt(st.nextToken());
        }
        buf = br.readLine();
        st = new StringTokenizer(buf);
        for (int j = 0; j < N; j++) {
            B[j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i] * B[N-1-i];
        }

        System.out.println(sum);
    }
}
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        nums[0] = 0;
        for(int i = 1; i <= N; i++) {
            nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int sum = nums[j] - nums[i-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}

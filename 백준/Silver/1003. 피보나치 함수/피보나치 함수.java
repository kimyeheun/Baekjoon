import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test = 0; test < T; test++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) sb.append(1).append(" ").append(0);
            else if (N == 1) sb.append(0).append(" ").append(1);
            else {
                int[][] nums = new int[N+1][2];
                nums[0][0] = 1;
                nums[0][1] = 0;
                nums[1][0] = 0;
                nums[1][1] = 1;
                for (int n = 2; n <= N; n++) {
                    nums[n][0] = nums[n-1][0] + nums[n-2][0];
                    nums[n][1] = nums[n-1][1] + nums[n-2][1];
                }
                sb.append(nums[N][0]).append(" ").append(nums[N][1]);
            }
            if(test != T -1)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}

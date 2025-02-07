import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        int result = 0;
        int idx = N-1;
        for(int n = 0; n < N-1; n++) {
            for(int m = idx; m > n; m--) {
                if (nums[n] + nums[m] == x) {
                    result++;
                    idx = m;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}

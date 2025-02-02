import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    static void backTracking(List<Integer> nums, int n) {
        if(nums.size() == M) {
            for (int num : nums) sb.append(num).append(" ");
            sb.append("\n");
        }

        for (int i = n + 1; i <= N; i++) {
            nums.add(i);
            backTracking(nums, i);
            nums.remove(Integer.valueOf(i));
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backTracking(new ArrayList<>(), 0);
        System.out.println(sb);
    }
}

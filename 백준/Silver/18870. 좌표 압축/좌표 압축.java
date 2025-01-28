import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int n = 0; n < N; n ++) {
            nums[n] = Integer.parseInt(st.nextToken());
            set.add(nums[n]);
        }

        int idx = 0;
        for(int t : set) {
            map.put(t, idx++);
        }

        int[] result = new int[N];
        for(int i = 0; i < N; i++) {
            result[i] = map.get(nums[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }
}

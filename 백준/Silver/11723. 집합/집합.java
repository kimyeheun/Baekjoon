import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        List<Integer> set = new ArrayList<>();

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();

            if (word.equals("all")) {
                set = new ArrayList<>();
                for(int i = 0; i <= 20; i ++) {
                    set.add(i);
                }
                continue;
            }
            else if (word.equals("empty")) {
                set = new ArrayList<>();
                continue;
            }

            int num = Integer.parseInt(st.nextToken());

            if (word.equals("add")) {
                if (set.isEmpty() || !set.contains(num)) set.add(num);
            }
            else if (word.equals("check")) {
                if (!set.isEmpty() && set.contains(num)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if (word.equals("toggle")) {
                if (!set.isEmpty() && set.contains(num)) set.remove(Integer.valueOf(num));
                else set.add(num);
            }
            else if (word.equals("remove")) {
                if (!set.isEmpty() && set.contains(num)) set.remove(Integer.valueOf(num));
            }
        }
        System.out.println(sb);
    }
}

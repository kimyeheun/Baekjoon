import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> names = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        int result_num = 0;
        for(int n = 0; n < N; n++) names.add(br.readLine());
        int size = names.size();
        for(int n = 0; n < M; n++) {
            String name = br.readLine();
            names.add(name);
            if(size == names.size()) {
                result.add(name);
                result_num++;
            }
            else size++;
        }

        Collections.sort(result);

        System.out.println(result_num);
        for(String r : result)
            sb.append(r).append("\n");
        System.out.println(sb);
    }
}

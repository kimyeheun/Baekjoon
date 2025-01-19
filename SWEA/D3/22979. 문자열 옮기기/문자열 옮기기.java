import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test <T; test++) {
            String line = br.readLine();
            int length = line.length();
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            for (int k = 0; k < K; k++) {
                sum += Integer.parseInt(st.nextToken());
                sum %= length;
            }

            if (sum == 0) {
                bw.append(line).append("\n");
                continue;
            }

            int idx;
            if (sum > 0) idx = sum % length;
            else idx = (length + sum) % length;

            for (int s = 0; s < line.length(); s++) {
                bw.append(line.charAt((idx + s) % length));
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
    }
}

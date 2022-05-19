import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int i = 1; i <= test; i++){
            int count = 0;
            String[] nums = br.readLine().split(" ");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);

            for (int y = N; y <= M; y++) {
                String Y = Integer.toString(y);
                for(int z = 0; z < Y.length(); z++) {
                    if(Y.charAt(z) == '0')
                        count++;
                }
            }
            System.out.println(count);
        }
    }
}

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words;

        while((words = br.readLine()) != null) {
            int[] count = new int[4];
            for (int i = 0; i < words.length(); i++) {
                int N = words.charAt(i);
                if (N >= 97 && N <= 122)
                    count[0]++;
                else if(N >= 65 && N <=90)
                    count[1]++;
                else if(N >= 48 && N <= 57)
                    count[2]++;
                else if(N == 32)
                    count[3]++;
            }
            for (int u = 0; u < count.length; u++) {
                System.out.print(count[u] + " ");
            }
            System.out.print("\n");
        }
    }
}
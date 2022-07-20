import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        for (int i = 0; i < words.length(); i++) {
            int N = words.charAt(i);
            if (97 <= N && N <= 122) {
                int R = N + 13;
                R = (R > 122) ? R - 122 + 97 - 1 : R;
                System.out.print((char)R);
            }
            else if (65 <= N && N <= 90) {
                int R = N +13;
                R = (R > 90) ? R - 90 + 65 -1 : R;
                System.out.print((char)R);
            }
            else if (48 <= N && N <= 57)
                System.out.print((char)N);
            else
                System.out.print(" ");
        }
    }
}
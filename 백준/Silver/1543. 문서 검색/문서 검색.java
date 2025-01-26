import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String sub = br.readLine();

        int result = 0;
        int idx = 0;

        while(idx + sub.length() <= word.length()) {
            String word2 = word.substring(idx, idx + sub.length());
            if (word2.equals(sub)) {
                idx += sub.length();
                result ++;
            }
            else idx++;
        }
        System.out.println(result);
    }
}

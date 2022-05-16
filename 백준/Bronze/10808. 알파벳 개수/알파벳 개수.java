import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        int[] count = new int[26];
        for(int i =0 ; i < words.length(); i++) {
            int N = words.charAt(i);
            count[N-97]++;
        }
        for(int u = 0; u < count.length; u++) {
            System.out.print(count[u]+" ");
        }
    }
}
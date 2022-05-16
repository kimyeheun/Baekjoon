import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        int[] count = new int[26];
        for(int y = 0; y <count.length; y++)
            count[y] = -1;
        for(int i =0 ; i < words.length(); i++) {
            int N = words.charAt(i);
            if(count[N-97] == -1)
                count[N-97] = i;
        }
        for(int u = 0; u < count.length; u++) {
            System.out.print(count[u]+" ");
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] buf = br.readLine().split("");
        Arrays.sort(buf, Collections.reverseOrder());
        for(int i = 0; i < buf.length; i++){
            System.out.print(buf[i]);
        }
        br.close();
    }
}
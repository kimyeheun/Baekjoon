import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split("");
        String[] binary = new String[n.length*3+1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n.length; i++) {
            int num = Integer.parseInt(n[i]);
            binary[i] = Integer.toBinaryString(num);
            if(binary[i].length() != 3 && i!=0) {
                int len = binary[i].length();
                if(len == 1)
                    sb.append("00");
                else if(len==2)
                    sb.append(0);
            }
            sb.append(binary[i]);
        }
        System.out.println(sb);
    }
}
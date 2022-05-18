import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        long n = Long.parseLong(s[0]);
        long r = Long.parseLong(s[1]);

        long total2 = count_2(n) - count_2(n-r) - count_2(r);
        long total5 = count_5(n) - count_5(n-r) - count_5(r);
        
        long result = Math.min(total2, total5);
        System.out.println(result);
    }

    static long count_2(long num) {
        long temp = num;
        while(temp >= 2 ) {
            num += temp / 2;
            temp /= 2;
        }
        return num;
    }
    static long count_5(long num) {
        long temp = num;
        while(temp >= 5 ) {
            num += temp / 5;
            temp /= 5;
        }
        return num;
    }
}

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = (N % 5 == 0) ? N / 5 : (N % 3 ==0) ? N / 3 : Integer.MAX_VALUE;
        if (N == 4 || N < 3) {
            System.out.println(-1);
            return;
        }

        int n = N / 5;
        for(int i = n; i >= 1; i--) {
        	if((N - (5*i)) % 3 == 0) result = Math.min(result, i + (N - (5*i)) / 3);
        }
        
        if (result == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(result);
    }
}

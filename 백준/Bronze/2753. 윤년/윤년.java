import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int year = Integer.parseInt(br.readLine()); //string이 리턴값이라 형변환 필수!
        //parse(파싱 - 구문 분석을 통해 위계관계를 분석하여 문장 구조를 결정) + Int(정수형)
        
        br.close();
        
        if ((year%4 ==0 && year%100 != 0 )|| year%400 == 0)
            bw.write("1");
        else 
            bw.write("0");
        
        bw.flush();
        bw.close();
        
    }
    
}

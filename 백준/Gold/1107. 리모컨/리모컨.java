import java.util.*;
 
public class Main {    
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        
        int target = sc.nextInt();
        int m = sc.nextInt();
        
        boolean[] broken = new boolean[10];
        
        for(int i = 0; i < m; i++) {
            int n = sc.nextInt();
            broken[n] = true;
        }
        
        int result = Math.abs(target - 100);
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            
            boolean isBreak = false;
            
            for(int j = 0; j < len; j++) {
                //고장난 버튼 누르면 더 이상 탐색하지 않음
                if(broken[str.charAt(j) - '0']) { 
                    isBreak = true; 
                    break; 
                }
            }
            //계속 탐색
            if(!isBreak) { 
                int min = Math.abs(target - i) + len; 
                result = Math.min(min, result);
            }
        }        
        System.out.println(result);
    }
}

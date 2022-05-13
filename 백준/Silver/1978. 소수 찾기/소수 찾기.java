import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        int result = 0;
        int[] nums = new int[num];
        
        
        for(int i = 0; i < num; i++) {
            nums[i] = sc.nextInt();
            int count = 0;
            
            if (nums[i] == 1){
                continue;
            }
            for (int u = 2; u < nums[i]; u++) {
                if(nums[i]%u == 0)
                    count++;
            }
            if(count == 0 | nums[i] == 2) 
                result++;
        }
        System.out.println(result);
    }
}
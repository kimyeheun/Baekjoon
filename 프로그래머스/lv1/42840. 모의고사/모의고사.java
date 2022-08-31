import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p = {0,0,0};
        
        int[] p_1 = {1,2,3,4,5};
        int[] p_2 = {2,1,2,3,2,4,2,5};
        int[] p_3 = {3,3,1,1,2,2,4,4,5,5};
        
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == p_1[r1++]) p[0]++;
            if(answers[i] == p_2[r2++]) p[1]++;
            if(answers[i] == p_3[r3++]) p[2]++;
            
            if(r1==5) r1 = 0;
            if(r2==8) r2 = 0;
            if(r3==10) r3 = 0;
            
        }
        
        int max = 0;
         for(int i = 0; i < 3; i++){
            if( p[i] >= max )
                max = p[i];
        }

        
        int num = 0;
        for(int r = 0; r < 3; r++) {
            if(p[r] == max)
                num++;
        }
        
        int[] answer = new int[num];
        
        int res = 0;
        for(int r = 0; r < 3; r++) {
            if(p[r] == max)
                answer[res++] = r + 1;
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        Arrays.fill(student, 1);
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i = 0; i < lost.length; i++) {
            student[lost[i]-1] = 0;
        }
        
        int answer = 0;
        
        for(int u = 0; u < reserve.length; u++){
            if(student[reserve[u] -1] == 0) {
                    student[reserve[u] -1] = 1;
                    reserve[u] = -1;
            }
        }
        
        
        for(int i = 0; i < student.length; i++) {
            if(student[i] == 0) {
                for(int u = 0; u < reserve.length; u++) {
                    if(reserve[u] == -1) 
                        continue;
                    else if(reserve[u] -2 == i || reserve[u] == i) {
                        student[i] = 1;
                        reserve[u] = -1;
                        break;
                    } 
                }  
            }  
        }
        
        for(int i = 0; i < student.length; i++) {
            if(student[i] == 1)
                answer++;
        }
    
        return answer;
    }
}
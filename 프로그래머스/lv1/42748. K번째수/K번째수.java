import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) { 
        
        int u;
        int[] answer = new int[commands.length];
        
        for(int a = 0; a < commands.length; a++) {
            u = 0;
            int[] res = new int[commands[a][1]-commands[a][0]+1];
            
            for(int i = commands[a][0]-1; i < commands[a][1]; i++) {
                res[u] = array[i];
                u++;
            }
            Arrays.sort(res);        
            answer[a] = res[commands[a][2]-1];
        }
        return answer;
    }
}
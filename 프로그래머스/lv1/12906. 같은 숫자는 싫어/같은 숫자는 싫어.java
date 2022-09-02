import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        
        int now = -1;
        
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                queue.add(arr[i]);
                now = arr[i];
            }
            else if(now != arr[i]) {
                queue.add(arr[i]);
                now = arr[i];
            }
        }
        
        int[] answer = new int[queue.size()];
        int u = 0;
        
        while(!queue.isEmpty()) {
            answer[u++] = queue.remove();
        }
    
        return answer;
    }
}
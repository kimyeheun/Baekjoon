import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = " ";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int check = 0;
        
        for(int i = 0; i < completion.length; i++) {
            if(!completion[i].equals(participant[i])) {
                answer = participant[i];
                break;
            }
            check = i;
        }
        
        if(check == completion.length - 1) {
            answer = participant[participant.length-1];
        }
        return answer;
    }
}
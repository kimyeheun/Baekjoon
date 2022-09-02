class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int min = 0;
        int max = 0;
        
        for(int i = 0; i < lottos.length; i++) {
            for(int u = 0; u < win_nums.length; u++) {
                if(lottos[i] == 0) {
                    max++;
                    break;
                }
                else if(win_nums[u] == lottos[i]) {
                    max++;
                    min++;
                    break;
                }
            }
        }
        
    
        if(max >= 2) {
            max = 7 - max;
        }
        else
            max = 6;
        
        if(min >= 2) {
            min = 7 - min;
        }
        else
            min = 6;
        
        int[] answer = {max, min};
        
        return answer;
    }
}
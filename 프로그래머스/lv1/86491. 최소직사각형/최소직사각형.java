class Solution {
    public int solution(int[][] sizes) {
        int w = 0; //min
        int h = 0; //max
        for(int a = 0; a < sizes.length; a++) {
            if(sizes[a][0] > sizes[a][1]) {
                if(w < sizes[a][1]) w = sizes[a][1];
                if(h < sizes[a][0]) h = sizes[a][0];
            }
            else {
                if(w < sizes[a][0]) w = sizes[a][0];
                if(h < sizes[a][1]) h = sizes[a][1];
            }
        }
                 
        return w * h;
    }
}
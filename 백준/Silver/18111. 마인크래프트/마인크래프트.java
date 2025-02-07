import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[][] land = new int[N][M];
        int minH = 256, maxH = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, land[i][j]);
                maxH = Math.max(maxH, land[i][j]);
            }
        }
        
        int bestTime = Integer.MAX_VALUE;
        int bestHeight = -1;
        
        for (int h = minH; h <= maxH; h++) {
            int removeBlocks = 0, addBlocks = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = land[i][j] - h;
                    
                    if (diff > 0) removeBlocks += diff;
                    else if (diff < 0) addBlocks -= diff;
                }
            }
            
            if (removeBlocks + B >= addBlocks) { // 블록이 충분한 경우
                int time = removeBlocks * 2 + addBlocks;
                if (time < bestTime || (time == bestTime && h > bestHeight)) {
                    bestTime = time;
                    bestHeight = h;
                }
            }
        }
        
        System.out.println(bestTime + " " + bestHeight);
    }
}

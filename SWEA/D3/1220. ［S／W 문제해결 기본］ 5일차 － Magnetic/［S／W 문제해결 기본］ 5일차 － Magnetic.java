import java.io.*;
import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int t = 0; t < 10; t++) {
            int n = Integer.parseInt(br.readLine());
             
            int[][] map = new int[n][n];
             
            // 맵 초기화
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
             
            // move가 없을 때 까지 반복
            boolean move = false;
            while(!move) {
                move = true;
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if (map[i][j] == 0 ) continue;
 
                        // s극의 경우 위로 올라감 
                        if (map[i][j] == 2) {
                            //바로 위가 없는 경우
                            if (i-1 < 0) {
                                map[i][j] = 0;
                                move = false;
                            }
                            // 바로 윗칸이 비어있는 경우
                            else if (map[i-1][j] == 0) {
                                map[i][j] = 0;
                                map[i-1][j] = 2;
                                move = false;
                            }
                            // else: n극 자석이 있는 경우
                        }
                         
                        // n극의 경우 아래로 내려감 : 역순 탐색 (아래단 부터 내리고 위로 올라가야 함)
                        int n_i = n - i - 1;
                        if (map[n_i][j] == 1) {
                            // 바로 아래가 없는 경우 
                            if (n_i+1 >= 100) {
                                map[n_i][j] = 0;
                                move = false;
                            }
                            // 바로 아래가 비어있는 경우
                            else if (map[n_i+1][j] == 0) {
                                map[n_i][j] = 0;
                                map[n_i + 1][j] = 1;
                                move = false;
                            }
                            // else: S극 자석이 있는 경우
                        }
                    }
                }
            }
             
            int result = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i + 1 < n) {
                        if (map[i][j] == 1 && map[i+1][j] ==2) result +=1; 
                    }
                }   
            }
            System.out.println("#" + (t+1) + " " + result);
        }
    }
}
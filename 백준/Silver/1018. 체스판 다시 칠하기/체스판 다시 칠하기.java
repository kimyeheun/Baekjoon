import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static int K = 8;

    static String compare;
    static byte[][] map;
    static int[][] repaintW;
    static int[][] repaintB;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new byte[N][M];
        repaintW = new int[N][M];
        repaintB= new int[N][M];

        byte[] compare = {'B','W'};

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = (byte) line.charAt(j);

                if (compare[(i + j) % 2] != map[i][j]) {
                    repaintW[i][j] = 1;
                    repaintB[i][j] = 0;
                }
                else {
                    repaintW[i][j] = 0;
                    repaintB[i][j] = 1;
                }
            }
        }

        // 누적 합 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) continue;
                if (i-1 < 0) {
                    repaintW[i][j] += repaintW[i][j-1];
                    repaintB[i][j] += repaintB[i][j-1];
                }
                else if (j - 1 < 0) {
                    repaintW[i][j] += repaintW[i-1][j];
                    repaintB[i][j] += repaintB[i-1][j];
                }
                else {
                    repaintW[i][j] += repaintW[i-1][j] + repaintW[i][j-1] - repaintW[i-1][j-1];
                    repaintB[i][j] += repaintB[i-1][j] + repaintB[i][j-1] - repaintB[i-1][j-1];
                }
            }
        }

        // K맵 변경 개수 계산하기
        int rW = repaintW[K-1][K-1];
        int rB = repaintB[K-1][K-1];
        for (int i = K-1; i < N; i++) {
            for(int j = K-1; j < M; j++) {
                if(i-K < 0 && j-K < 0) continue;
                if (i -K < 0) {
                    rW = Math.min(rW, repaintW[i][j] - repaintW[i][j-K]);
                    rB = Math.min(rB, repaintB[i][j] - repaintB[i][j-K]);
                }
                else if (j -K < 0) {
                    rW = Math.min(rW, repaintW[i][j] - repaintW[i-K][j]);
                    rB = Math.min(rB, repaintB[i][j] - repaintB[i-K][j]);
                }
                else {
                    rW = Math.min(rW, repaintW[i][j] - repaintW[i-K][j] - repaintW[i][j-K] + repaintW[i-K][j-K]);
                    rB = Math.min(rB, repaintB[i][j] - repaintB[i-K][j] - repaintB[i][j-K] + repaintB[i-K][j-K]);
                }
            }
        }
        int result = Math.min(rW, rB);

        System.out.println(result);
    }
}

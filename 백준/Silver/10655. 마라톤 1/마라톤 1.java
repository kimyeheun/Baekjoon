import java.io.*;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cordinates = new int[n][2];
        int[] dists = new int[n-1];
        int[] skipDists = new int[n-1];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cordinates[i][0] = Integer.parseInt(st.nextToken());
            cordinates[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n-1; i++) {
            dists[i] = Math.abs(cordinates[i][0] - cordinates[i+1][0]) +
                    Math.abs(cordinates[i][1] - cordinates[i+1][1]);
            if (i == n-2) continue;
            skipDists[i] = Math.abs(cordinates[i][0] - cordinates[i + 2][0]) +
                    Math.abs(cordinates[i][1] - cordinates[i + 2][1]);
        }

        int diff = Integer.MIN_VALUE;
        int excep = 0;
        for(int idx = 0; idx < n-2; idx++) {
            if (diff < dists[idx] + dists[idx +1] - skipDists[idx]){
                diff = dists[idx] + dists[idx +1] - skipDists[idx];
                excep = idx;
            }
        }
        int minDist = 0;
        for(int i = 0; i < n-1; i++) {
            if (i == excep) {
                minDist += skipDists[i];
                i++;
            }
            else minDist += dists[i];
        }

        System.out.println(minDist);
    }
}
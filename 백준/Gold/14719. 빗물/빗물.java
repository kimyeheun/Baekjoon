import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        Integer[] place = new Integer[w+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
            place[i] = Integer.parseInt(st.nextToken());
        }
        
        int rain = 0;
        for(int u = 1; u < place.length-2; u++) {
            int left_max = 0;
            int right_max = 0;
            for(int y = 0; y < u; y++) {
                if(left_max < place[y])
                    left_max = place[y];
            }
            for(int e = u+1; e < place.length-1; e++) {
                if(right_max < place[e])
                    right_max = place[e];
            }
            int min = Math.min(left_max, right_max);

            if(place[u] < min)
                rain += min - place[u];
        }
        System.out.println(rain);
    }
}
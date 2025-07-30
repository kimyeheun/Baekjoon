import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000; // 충분히 큰 수 (N이 50 이하라 1000이면 충분)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[][] friends = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    friends[i][j] = 0; // 자기 자신
                } else if (line.charAt(j) == 'Y') {
                    friends[i][j] = 1; // 친구
                } else {
                    friends[i][j] = INF; // 친구 아님
                }
            }
        }

        // 플로이드-워셜 알고리즘
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (friends[i][j] > friends[i][k] + friends[k][j]) {
                        friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && friends[i][j] <= 2) {
                    count++;
                }
            }
            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}

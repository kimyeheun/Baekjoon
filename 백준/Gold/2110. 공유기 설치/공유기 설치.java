import java.util.Arrays;
import java.util.Scanner;


public class Main {
    
    static boolean canInstall(int[] houses, int N, int C, int distance) {
        int count = 1;  
        int lastInstalled = houses[0]; 

        for (int i = 1; i < N; i++) {
            if (houses[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = houses[i]; 
            }
        }

        return count >= C;  
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  
        int C = sc.nextInt(); 
        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(houses);

        int left = 1; 
        int right = houses[N - 1] - houses[0];  
        int answer = 0;

        while (left <= right) {
            // 지금 공유기 거리
            int mid = (left + right) / 2;  
            if (canInstall(houses, N, C, mid)) {
                answer = mid;  // 조건 만족 → 더 큰 거리 탐색
                left = mid + 1;
            } else {
                right = mid - 1;  // 조건 불만족 → 거리 줄이기
            }
        }

        System.out.println(answer);
    }
}

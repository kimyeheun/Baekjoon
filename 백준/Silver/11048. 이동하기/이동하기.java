import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nandm = sc.nextLine().split(" ");
        int N = Integer.parseInt(nandm[0]);
        int M = Integer.parseInt(nandm[1]);

        int[][] candy = new int[N+1][M+1];
        int M_candy = 0;

        for(int i =1; i <= N; i++) {
            String[] line = sc.nextLine().split(" ");
            for(int u = 1; u <= M; u++) {
                candy[i][u] = Integer.parseInt(line[u-1]);
                M_candy = Math.max(Math.max(candy[i-1][u], candy[i][u-1]), candy[i-1][u-1]);
                candy[i][u] += M_candy;
            }
        }
        System.out.println(candy[N][M]);
    }
}

//[풀이]
//1. (N,M)의 입장에서 왼쪽 대각선 위, 위, 왼쪽의 값 중 가장 큰 값만 받아오면 된다.
//2. 이차원 배열 생성하여 사탕 개수 기록.
//3. 이때, 인덱스 오류를 예상하여 왼쪽 라인과 위쪽 라인을 하나씩 더 만들어 가져오는 값이 0이 되게 함.
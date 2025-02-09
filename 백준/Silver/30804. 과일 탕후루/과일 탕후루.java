import java.util.*;
import java.io.*;


public class Main {
    static int[] candy;
    static int resultMax = 0;
    static Set<Integer> set;
    
    static void calcCandy(boolean[] check) {
        int bufMax = 0;
        List<Integer> myCandy = new ArrayList<>();

        for(int c = 1; c < check.length; c++) {
            if(check[c]) myCandy.add(c);
        }

        for(int c : candy) {
            if (myCandy.contains(c)) bufMax++;
            else {
                resultMax = Math.max(bufMax, resultMax);
                bufMax = 0;
            }
        }
        resultMax = Math.max(bufMax, resultMax);
    }
    
    static void backTracking(boolean[] check, int now, int nums) {
        // 2개를 고르면, 탕후루 과일 개수 구하기
        if (nums == 2) {
            calcCandy(check);
            return;
        }
        if (now > 9) return;

        if (set.contains(now)) {
            check[now] = true;
            backTracking(check, now + 1, nums + 1);
            check[now] = false;
        }
        backTracking(check, now + 1, nums);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        candy = new int[N];
        set = new HashSet<>(); // 1 ~ 9

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            set.add(candy[i]);
        }

        if (set.size() <= 2) System.out.println(N);
        else {
            backTracking(new boolean[10], 1,0);
            System.out.println(resultMax);
        }
    }
}

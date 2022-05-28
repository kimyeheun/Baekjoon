import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 원생 수
        int K = sc.nextInt(); // 조 개수

        Integer[] student = new Integer[N+1];
        List<Integer> blank = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            student[i] = sc.nextInt();
        }
        for(int u = 0; u < N-1; u++) {
            blank.add(student[u+1] - student[u]);
        }

        blank.sort(Comparator.naturalOrder());
        int sum = 0;
        for(int y = 0; y <= blank.size()-K; y++) {
            sum = sum + blank.get(y);
        }
        System.out.println(sum);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 0; i < test; i++) {
            int case_ = sc.nextInt();
                double sum = 0;
                Integer[] score = new Integer[case_];
                for(int u = 0; u < case_; u++) {
                    score[u] = sc.nextInt();
                    sum = sum + score[u];
                }
            double avg = sum / (score.length);
            double student = 0;
            for(int y = 0; y <case_; y++){
                if (avg < score[y]) student = student + 1;
            }
            System.out.print(String.format("%.3f",student/(score.length)*100));
            System.out.println("%");
        }
    }
}

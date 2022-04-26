import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String[] test_case = new String[T];
        for (int i =0; i<T; i++) {
            test_case[i] = sc.nextLine();
            String[] word = test_case[i].split(" ");
            for (int u=0; u < word.length; u++){
                int w = word[u].length()-1;
                String result = "";
                while(w >= 0){
                    result = result + word[u].charAt(w--);
                }
                System.out.print(result+" ");
            }
            System.out.println();
        }
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] word = sc.nextLine().split("");
        String[] words = new String[word.length];
        for(int i = 0; i < word.length; i++) {
            String w = "";
            for(int u = i; u <word.length; u++) {
                w = w + word[u];
            }
            words[i] = w;
        }
        Arrays.sort(words);
        for(int y = 0; y < word.length; y++) {
            System.out.println(words[y]);
        }
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int word = sc.nextInt();
        List<String> list = new ArrayList<>();
        sc.nextLine();
        for(int i = 0; i <word; i++) {
            list.add(sc.nextLine());
        }
        List<String> rlist = list.stream().distinct().collect(Collectors.toList());
        String[] nlist = new String[rlist.size()];

        for(int i = 0; i < rlist.size(); i++) {
            nlist[i] = rlist.get(i);
        }
        Arrays.sort(nlist, new Comparator<String>() {
            @Override
            public int compare (String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        for (String s : nlist) {
            System.out.println(s);
        }
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int word = sc.nextInt();
        List<String> list = new ArrayList<>();
        
        //nextInt() 쓴 다음에 nextLine()쓰면 다음에 "\n"이 저장된다. 따라서 한 줄을 버림.
        sc.nextLine();
        
        for(int i = 0; i <word; i++) {
            list.add(sc.nextLine());
        }
        
        //중복 제거하여 정렬
        List<String> rlist = list.stream().distinct().collect(Collectors.toList());
        String[] nlist = new String[rlist.size()];

        for(int i = 0; i < rlist.size(); i++) {
            nlist[i] = rlist.get(i);
        }
        
        //오버라이딩하여 배열 정렬. 이때, 양수를 반환하면 위치를 바꾼다. 즉, 길이가 길면 뒤로 보내진다. 
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

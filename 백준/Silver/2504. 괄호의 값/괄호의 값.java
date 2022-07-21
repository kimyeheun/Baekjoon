import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        int[] check = new int[str.length()];
        int[] point = new int[str.length()];
        char[] a = str.toCharArray();
        int j = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char now = a[i];
            if (now == '(' || now == '[') {
                check[j++] = (now == '(' ) ? ')' : ']';
            }
            if (now == ')' || now == ']') {
                --j;
                if (j < 0 || check[j] != now) {
                    point[0] = 0;
                    break;
                }
                point[j] += (check[j] == ')' ? 2 : 3) * (point[j + 1] != 0 ? point[j + 1] : 1);
                point[j + 1] = 0;
            }
        }
        System.out.println(point[0]);
    }
}

import java.io.*;
import java.util.*;


class Main{
    static boolean checkCyclic(char[] original, char[] nums) {
        int len = original.length;
        for (int i = 0; i < len;  i++) {
            // 같은 숫자가 있으면,
            if (original[0] == nums[i]) {
                int j;
                for(j = 0; j < len; j++) {
                    // 순차 비교 
                    if (original[j] != nums[(i + j)%len]) break;
                }
                if (j == len) return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            int len = line.length();
            char[] original = new char[len];
            char[] nums = new char[len];
            for (int i = 0; i < len; i++) {
                char now = line.charAt(i);
                nums[i] = now;
                original[i] = now;
            }
            // 곱하기
            int up = 0;
            int mul;
            for(mul = 1; mul <= len; mul++) {
                for (int i = len - 1; i >= 0; i--) {
                    int newN = (original[i] - '0') * mul + up;
                    up = newN / 10;
                    nums[i] = (char) (newN % 10 + '0');
                }
                // false 이면, not cyclic
                if (!checkCyclic(original, nums)) break;
            }
            String now = new String(original);
            if (mul != len + 1) sb.append(now).append(" is not cyclic\n");
            else sb.append(now).append(" is cyclic\n");
        }
        System.out.println(sb);
    }
}
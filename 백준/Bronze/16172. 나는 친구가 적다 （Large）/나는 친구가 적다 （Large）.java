import java.io.*;

public class Main {
    static final int MOD = 1000000007;
    static final int BASE = 31; // 해시 기본값 (소수)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        String keyword = br.readLine();

        // 숫자 제거 과정
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }
        
        String filteredText = sb.toString();

        // 라빈-카프 알고리즘을 사용한 문자열 검색
        System.out.println(rabinKarp(filteredText, keyword) ? 1 : 0);
    }

    private static boolean rabinKarp(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        if (m > n) return false;

        long patternHash = 0, textHash = 0, power = 1;

        // 패턴 및 첫 번째 서브스트링 해시 계산
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * BASE + pattern.charAt(i)) % MOD;
            textHash = (textHash * BASE + text.charAt(i)) % MOD;
            if (i > 0) power = (power * BASE) % MOD; // BASE^(m-1)
        }

        // 롤링 해시를 이용해 문자열 검색
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                // 해시 충돌 시 실제 문자열 비교
                if (text.substring(i, i + m).equals(pattern)) {
                    return true;
                }
            }

            // 다음 윈도우로 해시 이동
            if (i < n - m) {
                textHash = (textHash - text.charAt(i) * power % MOD + MOD) % MOD; // 첫 글자 제거
                textHash = (textHash * BASE + text.charAt(i + m)) % MOD; // 새 글자 추가
            }
        }

        return false;
    }
}

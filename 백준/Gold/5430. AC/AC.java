import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			String line = br.readLine();
			int N = Integer.parseInt(br.readLine());
			
			String[] nums = br.readLine().split("\\[|\\,|\\]");
			
			boolean isReverse = false;
			int idx = 0;
			int idxR = 0;
			
			for(int i = 0; i < line.length(); i++) {
				char now = line.charAt(i);
				if(now == 'R') {
					isReverse = !isReverse;
				}
				else { // D
					if (isReverse) idxR++;
					else idx++;
					// 빈 리스트 D 오류 잡기
					if (N - idxR < idx) {
						sb.append("error").append("\n");
						break;
					}
				}
			}
			if (N - idxR < idx) continue;
			
			// 출력 부분 
			sb.append("[");
			if (isReverse) {
				for(int i = N-idxR; i > idx; i--) {
					sb.append(nums[i]);
					if (i != idx + 1) sb.append(",");
				}
			}
			else {
				for(int i = idx+1; i <= N-idxR; i++) {
					sb.append(nums[i]);
					if (i != N-idxR) sb.append(",");
				}
			}
			sb.append("]").append("\n");
		}
		System.out.println(sb);
	}
}


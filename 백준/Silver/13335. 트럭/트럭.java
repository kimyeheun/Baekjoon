import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken()); // 다리 길이
		int L = Integer.parseInt(st.nextToken()); // 최대 하중
		
		List<Integer> bridge = new ArrayList<>();
		int onbridge = 0;
		int trucks = 0;
		int time = 0;
		int first = 0;
		st = new StringTokenizer(br.readLine());
		
		int[] truck = new int[N];
		
		for(int n = 0; n < N; n++) {
			truck[n] = Integer.parseInt(st.nextToken());
		}
        
		for(int n = 0; n < N; n++) {
			int now = truck[n];
			
			// 앞에 트럭 내보내기 
			if (bridge.size() >= W) {
				onbridge -= bridge.get(first++);
				trucks--;
			}
			// 트럭을 올릴 수 있다면
			if (onbridge + now <= L && trucks +1 <= W) {
				bridge.add(now);
				onbridge += now;
				trucks++;
			}
			else { // 트럭을 올릴 수 없다면 
				bridge.add(0);
				n--;
			}
		}
		System.out.println(bridge.size() + W);
	}
}



import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int time[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		Arrays.sort(time, (a, b) -> {
			if(a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});

		int ans = 0;
		int endtime = 0;

		for (int i = 0; i < N; i++) {
			if (time[i][0] >= endtime) { 
				endtime = time[i][1];
				ans++;
			}
		}
		System.out.println(ans);
	}
}
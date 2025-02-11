import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int M;
	static int[] map = new int[101];
	static boolean[] visited = new boolean[101];
	static Map<Integer, Integer> ladder;
	static Map<Integer, Integer> snake;
	
	static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;
		map[i] = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.remove();
			for(int m : new int[]{1,2,3,4,5,6}) {
				int move = now + m;

				// 사다리를 가지고 있다면, 
				if (ladder.containsKey(move)) 
					move = ladder.get(move);
				// 뱀이 있다면 
				else if (snake.containsKey(move)) 
					move = snake.get(move);

				if (move < 0 || move > 100) continue;
				if (visited[move]|| map[move] != 0) continue;
				
				queue.add(move);
				visited[move] = true;
				map[move] = map[now]  +1;
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        ladder = new HashMap<>();
        snake = new HashMap<>();
        
        for(int n = 0; n < N; n++) {
        	st = new StringTokenizer(br.readLine());
        	ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        for(int m = 0; m < M; m++) {
        	st = new StringTokenizer(br.readLine()); 
        	snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        bfs(1);
        System.out.println(map[100]);
    }
}

import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] nodes = new int[V][V];
		
		for(int v = 0; v < V; v++) {
			Arrays.fill(nodes[v], Integer.MAX_VALUE);
		}
		for(int e = 0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int power = Integer.parseInt(st.nextToken());
			
			nodes[n1-1][n2-1] = power;
		}
		
		for(int i = 0; i < V; i++) {
			for(int s = 0; s < V; s++) {
				for(int e = 0; e < V; e++) {
					if(nodes[s][i] == Integer.MAX_VALUE || nodes[i][e] == Integer.MAX_VALUE) continue;
					nodes[s][e] = Math.min(nodes[s][e], nodes[s][i] + nodes[i][e]);
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < V; i++) {
			result = Math.min(result, nodes[i][i]);
		}
		
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.println(result);
	}
}

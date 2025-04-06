import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int M;
    static int result = Integer.MAX_VALUE;
    static int[][] map;
    static List<CCTV> cctvs = new ArrayList<>();
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우, 하, 좌, 상
    static int[][][] cctvModes = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    static class CCTV {
    	int n;
    	int m;
    	int type;
    	
    	CCTV(int n, int m, int type) {
    		this.n = n;
    		this.m = m;
    		this.type = type;
    	}
    }
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
            	map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0);
        System.out.println(result);
    }

    static void dfs(int depth) {
        if (depth == cctvs.size()) {
        	result = Math.min(result, countBlindSpot());
            return;
        }

        CCTV cctv = cctvs.get(depth);

        for (int[] mode : cctvModes[cctv.type]) {
            List<int[]> changed = markArea(cctv.n, cctv.m, mode);
            dfs(depth + 1);
            restoreArea(changed);
        }
    }

    static List<int[]> markArea(int n, int m, int[] mode) {
        List<int[]> changed = new ArrayList<>();

        for (int d : mode) {
            int nx = n, ny = m;
            while (true) {
                nx += move[d][0];
                ny += move[d][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) break;
                if (map[nx][ny] == 0) {
                	map[nx][ny] = -1;
                    changed.add(new int[]{nx, ny});
                }
            }
        }
        return changed;
    }

    static void restoreArea(List<int[]> changed) {
        for (int[] pos : changed) {
            map[pos[0]][pos[1]] = 0;
        }
    }

    static int countBlindSpot() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }
}

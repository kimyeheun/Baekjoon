import java.io.*;
import java.util.*;


class Main{
    static int N;
    static List<Node> cordinates;
    static List<Node> teachers;
    static int[][] map;
    static int[][] looks = {{0, 1}, {0, -1}, {1, 0}, {-1,0}};;

    static class Node {
        int n;
        int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, m);
        }
        @Override
        public boolean equals(Object o) {
            if (this==o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node n = (Node) o;
            return n.n == this.n && n.m == this.m;
        }

        @Override
        public String toString() {
            return n + " " + m;
        }
    }

    static boolean checkHide() {
        // 선생님 걸리는지 확인
        for(Node T : teachers) {
            int x = T.n;
            int y = T.m;
            for(int[] mv : looks) {
                for(int i = 1; i < N; i++) {
                    int nextn = x + i * mv[0];
                    int nextm = y + i * mv[1];
                    if (nextn < 0 || nextm < 0 || nextn >= N || nextm >= N) break;
                    if (map[nextn][nextm] == 2) break;
                    if (map[nextn][nextm] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static void backTracking(int ob, int num, boolean[] visited) {
        if (num > ob) return;
        if (num == ob) {
            // 장애물 설치
            for(int i = 0; i < cordinates.size(); i++) {
                if (visited[i]) {
                    Node now = cordinates.get(i);
                    map[now.n][now.m] = 2;
                }
            }
            if (checkHide()) {
                System.out.println("YES");
                System.exit(0);
            }
            // 장애물 해체
            for(int i = 0; i < cordinates.size(); i++) {
                if (visited[i]) {
                    Node now = cordinates.get(i);
                    map[now.n][now.m] = 0;
                }
            }
            return;
        }
        for(int i = 0; i < cordinates.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            backTracking (ob, num+1, visited);
            visited[i] = false;
        }
    }

    public static void lookAhead(Node T) {
        int tx = T.n;
        int ty = T.m;

        // 오른쪽 확인
        int look;
        for(look = 1; ty + look < N; look++) {
            if (map[tx][ty + look] == 1) break;
        }
        if (ty + look != N) {
            for (int idx = 1; idx < look; idx++) {
                Node n = new Node(tx, ty + idx);
                if (!teachers.contains(n) && !cordinates.contains(n))
                    cordinates.add(n);
            }
        }

        // 왼쪽
        for(look = 1; ty - look >= 0; look++) {
            if (map[tx][ty - look] == 1) break;
        }
        if (ty - look >= 0) {
            for (int idx = 1; idx < look; idx++) {
                Node n = new Node(tx, ty - idx);
                if (!teachers.contains(n) && !cordinates.contains(n))
                    cordinates.add(n);
            }
        }

        // 위쪽
        for(look = 1; tx - look >= 0; look++) {
            if (map[tx - look][ty] == 1) break;
        }
        if (tx - look >= 0) {
            for (int idx = 1; idx < look; idx++) {
                Node n = new Node(tx - idx, ty);
                if (!teachers.contains(n) && !cordinates.contains(n))
                    cordinates.add(n);
            }
        }

        // 아래쪽
        for(look = 1; tx + look < N; look++) {
            if (map[tx + look][ty] == 1) break;
        }
        if (look + tx != N) {
            for (int idx = 1; idx < look; idx++) {
                Node n = new Node(tx + idx, ty);
                if (!teachers.contains(n) && !cordinates.contains(n))
                    cordinates.add(n);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        /*
            백트래킹

            1. 선생님의 위치를 리스트로 유지.
            2. 선생님의 상하좌우를 보고, 학생이 그 끝에 있다면, 장애물을 놔야 하는 공간으로 간주. 배열로 유지
            3. 백트래킹 (int num, boolean[] visited (위 장애물 배열의 인덱스))
        **/
        map = new int[N][N];
        teachers = new ArrayList<>();
        cordinates = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                String now = st.nextToken();
                if (now.equals("T")) teachers.add(new Node(i, j));
                else if (now.equals("S")) map[i][j] = 1;
            }
        }
        if (teachers.isEmpty()) {
            System.out.println("YES");
            return;
        }
        for (Node T : teachers) {
            lookAhead(T);
        }
        if (cordinates.isEmpty() || teachers.isEmpty()) {
            System.out.println("NO");
            return;
        }

        boolean[] visited = new boolean[cordinates.size()];
        backTracking(Math.min(3, cordinates.size()), 0, visited);

        System.out.println("NO");
    }
}
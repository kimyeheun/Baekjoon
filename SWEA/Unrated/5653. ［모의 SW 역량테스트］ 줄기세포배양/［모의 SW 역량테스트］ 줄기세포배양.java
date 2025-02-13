import java.io.*;
import java.util.*;


public class Solution {
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Cell {
        int n;
        int m;
        int s; // safe : 기본적으로 살 수 있는 시간     ex) 2 (기본 수 = 노란색)
        int t; // time to activate : 활성화 시작 시간  ex) 2 (파란색)
        int e; // end to activate : 활성화 끝나는 시간  ex) 4 (회색)

        Cell(int n, int m, int s, int t, int e) {
            this.n = n;
            this.m = m;
            this.s = s;
            this.t = t;
            this.e = e;
        }

        @Override
        public boolean equals(Object cell) {
            if (this == cell) return true;

            if (cell == null || cell.getClass() != getClass()) return false;
            Cell cell2 = (Cell) cell;
            return cell2.n == this.n && cell2.m == this.m;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, m);
        }

        @Override
        public String toString() {
            return n + " " + m + " "+ s + " " + t + " " + e;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());;
            int K = Integer.parseInt(st.nextToken());

            Set<Cell> visited = new HashSet<>();
            PriorityQueue<Cell> queue = new PriorityQueue<>((s, e) -> { return e.s - s.s; });

            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++) {
                    int now = Integer.parseInt(st.nextToken());
                    if (now != 0) {
                        Cell nowC = new Cell(n, m, now, now, now + now); // 0 0 1 1 2
                        queue.add(nowC);
                        visited.add(nowC);
                    }
                }
            }

            // bfs
            int time = 0;
            // queue를 임시로 대신할 큐 (새로 생성되는 세포들이 들어간다.)
            PriorityQueue<Cell> buf = new PriorityQueue<>((s, e) -> { return e.s - s.s; });
            // 새로 세포를 만든 노드들을 담는 큐 (더 오래 살아있는 것들이 제일 먼저 빠진다.)
            PriorityQueue<Cell> stillActivate = new PriorityQueue<>((s, e) -> { return e.e - s.e; });

            // 같은 위치에 동시에 번식하려는 경우 -> 더 높은 시간을 가진 세포가 번식 함. (우선순위 큐 정렬)
            while (time < K) {
                // 한 턴이 끝났으면, 큐 바꾸기 + 시간 늘리기
                if (queue.isEmpty()) {
                    queue.addAll(buf);
                    buf.clear();
                    time++;
                    continue;
                }

                Cell now = queue.poll();

                // 지금 위치의 세포가 활성 상태 이면 (파란색)
                if (now.t == time) {
                    stillActivate.add(now); // (파란색 ~ 검은색)

                    // 주의를 둘러보며 visit되지 않은 장소를 찾는다.
                    for (int[] mv : move) {
                        int nextn = now.n + mv[0];
                        int nextm = now.m + mv[1];
                        Cell next = new Cell(nextn, nextm, now.s, now.s + now.t + 1, (now.s * 2) + now.t + 1);
                        // 방문 안 했으면 세포 분열 
                        if (!visited.contains(next)) {
                            visited.add(next);
                            buf.add(next);
                        }
                    }
                }
                // 지금 위치의 세포가 비활성 상태라면 (노란색)
                else buf.add(now);
            }

            // 노란색 - 비활성 + 사라지지는 않은 상태 
            int result = queue.size();

            // 파란색 - 활성 상태 
            for(Cell c : stillActivate) {
                if (K < c.e) result++;
            }

            System.out.println("#" + t + " " + result);
        }
    }
}

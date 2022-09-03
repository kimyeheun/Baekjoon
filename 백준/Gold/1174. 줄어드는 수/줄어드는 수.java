import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> queue = new LinkedList<>();
        int N = sc.nextInt();

        for(int i = 0; i < 10; i++) { queue.add(Integer.toString(i)); }

        int loop = 0;
        String buf = "";
        String answer = "";

        while(!queue.isEmpty()) {
            loop++;
            answer = queue.poll();
            buf = answer.substring(answer.length()-1);
            if(answer.equals("9876543210") || loop == N) {
                break;
            }

            for(int u = 0; u < Integer.parseInt(buf); u++) {
                String U = Integer.toString(u);
                queue.add(answer + U);
            }
        }

        if(loop == N)
            System.out.println(answer);
        else
            System.out.println(-1);
    }
}

//[풀이] - BFS!
//* bfs를 이용해보자.
//1. 큐에 0~9까지 집어 넣는다.
//2. 큐가 빌 때까지 while문 돌림
//3. 큐에서 꺼낸 숫자를 임시로 넣어두고(String) 이 수보다 작은 수가 있다면 앞 숫자와 붙여서 큐에 저장(for문).
//4. N번째에 while문 탈출. 출력. return
//5. 큐가 비었는데 탈츨하지 못했다면 -1
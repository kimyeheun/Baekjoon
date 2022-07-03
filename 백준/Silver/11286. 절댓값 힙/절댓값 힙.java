import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2) 
                return o1 > o2 ? 1 : -1;
            
            return abs1 - abs2;
        });

        for(int i = 0 ; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            
            if(a == 0){
                if(queue.isEmpty()) 
                    System.out.println("0");
                else 
                    System.out.println(queue.poll());
            }
            else
                queue.add(a);
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
  static int[][] check; 
  static boolean[] checked;   
  static int n; 
  static int m; 
  static int start; 
  
  public static void main(String[] args) throws IOException {
  Scanner sc = new Scanner(System.in);
  n = sc.nextInt();
  m = sc.nextInt();
  start = sc.nextInt();
  
  check = new int[1001][1001];
  checked = new boolean[1001];
  
  
  for(int i = 0; i < m; i++) {
    int x = sc.nextInt();
    int y = sc.nextInt();
    
    check[x][y] = check[y][x] = 1;
  }
  
  dfs(start); 
  
  checked = new boolean[1001]; 
  
  System.out.println(); 
  bfs(); 
  }
  
  public static void dfs(int i) {
    checked[i] = true;
    System.out.print(i + " ");
    
    for(int j = 1; j <= n; j++) {
      if(check[i][j] == 1 && checked[j] == false) {
        dfs(j);
      }
    }
  }
  
  public static void bfs() {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(start); 
    checked[start] = true;
    System.out.print(start + " ");
    
    while(!queue.isEmpty()) {
      int temp = queue.poll();
      
      for(int j = 1; j <= n; j++) {
        if(check[temp][j] == 1 && checked[j] == false) {
          queue.offer(j);
          checked[j] = true;
          System.out.print(j + " ");
        }
      }
    }
  }
}
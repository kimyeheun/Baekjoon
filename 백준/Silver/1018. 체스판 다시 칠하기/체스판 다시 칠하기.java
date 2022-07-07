import java.util.Scanner; 

public class Main { 	
    public static void main(String[] args) { 				
    Scanner sc = new Scanner(System.in); 		 		
    int n = sc.nextInt(); 		
    int m = sc.nextInt(); 		 		
    char[][] board = new char[n][m];

    //비교 대상 체스판 
    for(int i=0; i<n; i++) 		
    { 			
        String str = sc.next(); 	
	for(int j=0; j<m; j++)
        { 				
            board[i][j] = str.charAt(j); 	
        } 
    } 		 		
	
    char[][] Wboard = new char[8][8]; 		
 	for(int i=0; i<8; i++) 	
	{ 			
            String str; 	
	    if(i%2==0) 		
		str = "WBWBWBWB"; 	
	    else 		
		str = "BWBWBWBW"; 		
	    for(int j=0; j<8; j++) 	
	    { 			
        	Wboard[i][j] = str.charAt(j); 			
            } 	
	} 		 		
		
     char[][] Bboard = new char[8][8]; 	
	 for(int i=0; i<8; i++) 	
 	 { 		
             String str; 		
             if(i%2==0) 		
		str = "BWBWBWBW"; 		
             else 		
		str = "WBWBWBWB"; 	
	     for(int j=0; j<8; j++) 	
	     { 		
		Bboard[i][j] = str.charAt(j); 	
	      } 
          } 	
	
        int Wcount = 0; 	
	int Bcount = 0; 	
	int count = 0; 	
	int min = Integer.MAX_VALUE; 	
	int start = 0; 		

	for(int i=0; i<=n-8; i++) 
 	{ 	
		for(int j=0; j<=m-8; j++)
		{ 	
			for(int a=i; a<i+8; a++) 	
			{ 		
			    for(int b=j; b<j+8; b++)
 			    {
 				if(board[a][b] != Wboard[a-i][b-j]) 
					Wcount++; 	
				if(board[a][b] != Bboard[a-i][b-j])	
					Bcount++; 	
			    } 		
			 } 				
                         count = (Wcount>=Bcount) ? Bcount:Wcount; 	
			if(count<=min) 	
				min = count; 
				Wcount = 0;
 				Bcount = 0; 
			}
 		} 		
                System.out.println(min);
 	}
 }

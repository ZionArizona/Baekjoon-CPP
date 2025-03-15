import java.util.*;
import java.io.*;

public class Main {
	
	static int R,C;
	static char[][] arr;
	static int[] drow = {-1,0,0,1};  // 상 좌 우 하
	static int[] dcol = {0,-1,1,0};

	static private class Point{
	    int x;
	    int y;

	    private Point(int x, int y){
	        this.x = x;
	        this.y = y;
	    }

	}

	
	static int[][] firearr;
	static int[][] Jiarr;
	static Queue<Point> fireque = new ArrayDeque<>();
	static Queue<Point> Jique = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    
	    arr = new char[R][C];
	    
	    firearr = new int[R][C];
	    Jiarr = new int[R][C];
	    
	    for(int i = 0; i < R; i++) {
	    	Arrays.fill(firearr[i], -1);
	    	Arrays.fill(Jiarr[i], -1);
	    	
	    }
	    
	    for(int i = 0; i < R; i++) {
	    	String str = br.readLine();
	    	for(int j = 0; j < C; j++) {
	    		arr[i][j] = str.charAt(j);
	    		if(arr[i][j] == 'J') {
	    			Jiarr[i][j] = 0;
	    			Jique.offer(new Point(i,j));
	    		}
	    		if(arr[i][j] == 'F') {
	    			firearr[i][j] = 0;
	    			fireque.offer(new Point(i,j));
	    		}
	    	}
	    }
	    
	    // 불먼저 이동
	    firemove();
	    
	    int ans = Jimove();
	    
	    if(ans == -1) {
	    	System.out.println("IMPOSSIBLE");
	    }
	    else {
	    	System.out.println(ans);
	    }
	    
	} // main

	static private int Jimove() {
		
		while(!Jique.isEmpty()) {
			
			Point J = Jique.poll();
			
			if(J.x == 0 || J.x == R-1 || J.y == 0 || J.y == C-1) return Jiarr[J.x][J.y] + 1; 
			
			for(int i = 0; i < 4; i++) {
				
				int nextrow = J.x + drow[i];
				int nextcol = J.y + dcol[i];
				
				if(nextrow >= 0 && nextrow < R && nextcol >= 0 &&  nextcol < C) {
					
					if(arr[nextrow][nextcol] == '.' && Jiarr[nextrow][nextcol] == -1) {
						
						if(firearr[nextrow][nextcol] == -1 || Jiarr[J.x][J.y] + 1 < firearr[nextrow][nextcol] ) {
							Jiarr[nextrow][nextcol] = Jiarr[J.x][J.y] + 1;
							Jique.offer(new Point(nextrow, nextcol));
						}
					}
				}
			}
		}
		
		return -1;
	} // Jimove
	
	
	static private void firemove() {
		
		while(!fireque.isEmpty()) {
			
			Point f = fireque.poll();
			
			for(int i = 0; i < 4; i++) {
				
				int nextrow = f.x + drow[i];
				int nextcol = f.y + dcol[i];
				
				if(nextrow >= 0 && nextrow < R && nextcol >= 0 && nextcol < C) {
					
					if(arr[nextrow][nextcol] == '.' && firearr[nextrow][nextcol] == -1) {
						firearr[nextrow][nextcol] = firearr[f.x][f.y] + 1; 
						fireque.offer(new Point(nextrow,nextcol));
					}
				}
			}
		}
	} //firemove
}
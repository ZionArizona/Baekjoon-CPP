import java.util.*;
import java.io.*;


public class Main {
	
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int ans;
	static int[] dcol = {0,0,-1,1};  // 상  하  좌   우
	static int[] drow = {-1,1,0,0};
	static int Min = 1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
        int minHeight = 101;
        int maxHeight = 0;
        
        
		for(int i=  0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				minHeight = Math.min(minHeight, arr[i][j]);
                maxHeight = Math.max(maxHeight, arr[i][j]);
			}
		}
		
		
		//System.out.println(list.size());
		
		
		
		for(int num = minHeight; num <= maxHeight; num++) {
			
			visited = new boolean[N][N];
			
			
			
			ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(chk(i,j) && arr[i][j] > num) {
						go(i,j,num);
						ans++;
					}

				}
			}
			Min = Math.max(Min, ans);
		}
		
		
		System.out.println(Min);
		
	} // main
	
	
	
	
	static void go(int row, int col,int h) {
		
		visited[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextrow = row + drow[i];
			int nextcol = col + dcol[i];
			
			if(chk(nextrow,nextcol) && arr[nextrow][nextcol] > h) {
				go(nextrow, nextcol,h);
			}
			
		}
		
	} // go
	
	
	
	static boolean chk(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N && !visited[row][col];
	} // chk
	
	
}
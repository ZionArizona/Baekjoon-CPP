import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[][] visited;
	static int[][] arr;
	static int[] drow = {0, 0, 1, -1, -1, 1, -1, 1}; // 좌 우 상 하 좌상 좌하 우상 우하
    static int[] dcol = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int N;
	static int row;
	static int col;
	static int width;
	static int height;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			if(width == 0 && height == 0) {
				break;
			}
			
			arr = new int[height][width];
			visited = new boolean[height][width];
			
			
			for(int i = 0; i < height; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < width; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					if(!visited[i][j] && arr[i][j] == 1) {
						go(i,j);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
	
		}	//while
		

			
	}// main
	
	
	private static void go(int row, int col) {
		
		visited[row][col] = true;
		
		for(int i = 0; i < 8; i++) {
			int nextrow = row + drow[i];
			int nextcol = col + dcol[i];
			
			
			if(nextrow >= 0 && nextrow < height && nextcol >=0 && nextcol < width && !visited[nextrow][nextcol] && arr[nextrow][nextcol] == 1) {
				go(nextrow, nextcol);
			}
			
			
		}
		
		
		
		
	} //go
	
}
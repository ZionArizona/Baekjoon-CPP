import java.util.*;
import java.io.*;

public class Main {

	static char[][] org;
	static char[][] orgA;
	static int N;
	static int[] drow = {-1,1,0,0};  // 상  하  좌  우
	static int[] dcol = {0,0,-1,1};
	static int ans;
	static int ansA;
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		org = new char[N][N];
		orgA = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < N; j++) {
				org[i][j] = str.charAt(j);
				if(org[i][j] == 'R' || org[i][j] == 'G') orgA[i][j] = 'R';
				else orgA[i][j] = org[i][j];
			}	
		}
		
		ans = 0;
		visited = new boolean[N][N];
		// 정상인 사람
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					ans++;
					char type = org[i][j];
					go(i,j, type);
				}
			}
			
		}
		
		ansA = 0;
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					ansA++;
					char type = orgA[i][j];
					go2(i,j, type);
				}
			}
			
		}
		
		System.out.println( ans + " "+ ansA);
		
	} // main
	
	static void go(int row, int col, char chk) {
		
		visited[row][col] = true;
		
		
		for(int i = 0; i < 4; i++) {
			int nextrow = row + drow[i];
			int nextcol = col + dcol[i];
			
			
			if(nextrow >= 0 && nextrow < N && nextcol >= 0 && nextcol < N && !visited[nextrow][nextcol] && org[nextrow][nextcol] == chk) {
				go(nextrow, nextcol, chk);
				
			}
			
		}
		
	} //go
	
	
static void go2(int row, int col, char chk) {
		
		visited[row][col] = true;
		
		
		for(int i = 0; i < 4; i++) {
			int nextrow = row + drow[i];
			int nextcol = col + dcol[i];
			
			
			if(nextrow >= 0 && nextrow < N && nextcol >= 0 && nextcol < N && !visited[nextrow][nextcol] && orgA[nextrow][nextcol] == chk) {
				go2(nextrow, nextcol, chk);
				
			}
			
		}
		
	} //go2
	
	
}

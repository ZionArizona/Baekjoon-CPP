import java.util.*;
import java.io.*;


public class Main {
	
	static int N;
	static int M;
	static char[][] arr;
	static int[] drow = {-1,1,0,0}; // 상   하    좌     우
	static int[] dcol = {0,0,-1,1};
	static int sR;
	static int sE;
	static int ans;
	static boolean[][] vis;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		vis = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				
				if(str.charAt(j) == 'I') {
					sR = i;
					sE = j;
				}
				arr[i][j] = str.charAt(j);
			}
		}
		
		ans = 0;

		go(sR, sE);
		
		if(ans == 0) {
			System.out.println("TT");
		}
		else {
			System.out.println(ans);
		}
		
	} //
	
	static void go(int row, int col) {
		vis[row][col] = true;
		
		if(arr[row][col] == 'P') {
			ans++;
		}
		
		for(int i = 0; i < 4; i++) {
			
			int nextrow = row + drow[i];
			int nextcol = col + dcol[i];
			
			if(nextrow >= 0 && nextrow < N && nextcol >= 0 && nextcol < M && !vis[nextrow][nextcol] && arr[nextrow][nextcol] != 'X') {
				go(nextrow, nextcol);
			}
			
		}
		
	} // go

}
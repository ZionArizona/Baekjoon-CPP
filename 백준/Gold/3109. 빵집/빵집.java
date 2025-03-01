import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[][] arr;
	static int ans = 0;
	static int R;
	static int C;
	static int[] drow = {-1,0,1};  // 우상    우     우하
	static int[] dcol = {1,1,1};
	static boolean flag;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				String chk = String.valueOf(input.charAt(j));
				if(chk.equals("x")) {
					arr[i][j] = true;
				}
			}
		}
		
		
		for(int i = 0; i < R; i++) {
			flag = false;
			go(i,0);
		}
		
		System.out.println(ans);
		
	}  // main
	
	
	public static void go(int row, int depth) {
			
		
		if(depth == C-1) {
			ans++;
			flag = true;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			int nextrow = row + drow[i];
			int nextcol = depth + dcol[i];
			
			if(chk(nextrow, nextcol)) {
				arr[nextrow][nextcol] = true;
				go(nextrow, nextcol);
			}
			
			if(flag == true) {
				return;
			}
			
		}
			
	} // go
	
	
	
	public static boolean chk(int row, int col) {
		
		return row >= 0 && row < R && col >= 0 && col < C && !arr[row][col];
		
	}
	
	
}

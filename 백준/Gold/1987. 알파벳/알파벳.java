import java.util.*;
import java.io.*;

public class Main {
	
	static char[][] arr;
	static int R;
	static int C;
	static int ans;
	static int[] drow = {-1,1,0,0};  // 상   하    좌   우
	static int[] dcol = {0,0,-1,1};
	static boolean[][] visited;
	static Set<Character> set;
	static int tmpans;
	//static Set<char> set;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		set = new HashSet<>();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		ans = 1;
		tmpans = 1;
		set.add(arr[0][0]);
		
		go(0,0);
		
		System.out.println(ans);
		
	}
	
	static void go(int row, int col) {
		
		visited[row][col] = true;
		
		
		for(int i = 0; i < 4; i++) {
			
			int nextrow = row + drow[i];
			int nextcol = col + dcol[i];
			
			if(nextrow >= 0 && nextrow < R && nextcol >= 0 && nextcol < C && !visited[nextrow][nextcol] && !set.contains(arr[nextrow][nextcol])) {
				
				tmpans++;
				set.add(arr[nextrow][nextcol]);
				go(nextrow, nextcol);
				tmpans--;
				set.remove(arr[nextrow][nextcol]);
				visited[nextrow][nextcol] = false;
			}
			
		}
		
		ans = Math.max(ans, tmpans);
		
	}  // go
	
}
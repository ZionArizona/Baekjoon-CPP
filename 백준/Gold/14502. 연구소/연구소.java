import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int[][] arr;
	static int[] drow = {-1,1,0,0}; // 상  하   좌   우
	static int[] dcol = {0,0,-1,1};
	static boolean[][] vis;
	static int[][] tmparr;
	static List<Point> list;
	static List<Point> Zlist;
	static Point[] pos;
	static int ans;
	
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		pos = new Point[3];
		list = new ArrayList<>();
		Zlist = new ArrayList<>();
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) list.add(new Point(i,j));
				if(arr[i][j] == 0) Zlist.add(new Point(i,j)); 
			}
		}
		ans = Integer.MIN_VALUE;
		//조합
		go(0,0);
		
		System.out.println(ans);
	} // main
	
	
	static void go(int start, int depth) {
		
		if(depth == 3) {
			
			simul();
			
			return;
		}
		
		for(int i = start; i < Zlist.size(); i++) {
			
			pos[depth] = Zlist.get(i);
			go(i+1, depth+1);
			
		}
		
	} // go
	
	
	static void simul() {
		tmparr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			tmparr[i] = arr[i].clone();
		}
		
		for(int i = 0; i < 3; i++) {
			Point p = pos[i];
			int x = p.x;
			int y = p.y;
			
			tmparr[x][y] = 1;
			
		}
		
		vis = new boolean[N][M];
		
		for(int i = 0; i < list.size(); i++) {
			Point chk = list.get(i);
			if(!vis[chk.x][chk.y]) {
				dfs(chk.x, chk.y);
			}
		}
		
		ans = Math.max(ans, count());
		
	} // simul
	
	static void dfs(int row, int col) {
		
		vis[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
				
			int nextrow = row + drow[i];
			int nextcol = col + dcol[i];
				
			if(nextrow >= 0 && nextrow < N && nextcol >= 0 && nextcol < M && !vis[nextrow][nextcol] && tmparr[nextrow][nextcol] == 0) {
				tmparr[nextrow][nextcol] = 2;
				dfs(nextrow, nextcol);
			}		
		}
	} //dfs
	
	
	static int count() {
		
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmparr[i][j] == 0) sum++;
			}
		}
		
		return sum;
	} // count
	
}
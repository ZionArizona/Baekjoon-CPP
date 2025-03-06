import java.util.*;
import java.io.*;

public class Main {
	
	static int ans;
	static int[][] arr;
	static int[][] cmap;
	static boolean[][] visited;
	static int N;
	static int M;
	//static boolean[][] visited;
	static int[] drow = {-1,1,0,0};  // 상   하    좌   우
	static int[] dcol = {0,0,-1,1};
	static List<Integer> listx;
	static List<Integer> listy;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		//visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
//				if(arr[i][j] == 0) {
//					//visited[i][j] = true;
//				}
			}
		}
		
//		for(int i = 0; i < M; i++) {
//			arr[0][i] = -1;
//			//visited[0][i] = true;
//			arr[N-1][i] = -1;
//			//visited[N-1][i] = true;
//		}
//		
//		for(int i = 0; i < N; i++) {
//			arr[i][0] = -1;
//			//visited[i][0] = true;
//			arr[i][M-1] = -1;
//			//visited[i][M-1] = true;
//		}
		
		
//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < M; c++) {
//				System.out.print(arr[r][c] + " ");
//			}
//			System.out.println();
//		}
//		
		
		List<Integer> list = new ArrayList<>();
		
		int i = 0;
		
		while(true) {
			
			visited = new boolean[N][M];
			int tmpans = 0;
			
			 cmap = new int[N][M];
			 for(int r = 0; r < N; r++) {
				 cmap[r] = arr[r].clone();
			 }
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(arr[r][c] == 0) continue;
					tmpans += arr[r][c];
				}
			}
			
			
			
			if(tmpans == 0) break;
			
			
			// tmpans가 0이 아니면 외각에 있는 치즈를 삭제해줘야 한다.
			list.add(tmpans);
//			for(int r = 0; r < N; r++) {
//				for(int c = 0; c < M; c++) {
//					
//					if(arr[r][c] == 0) {
//						System.out.println("main :   " +  r + "   " + c);
//						go(r,c,cmap);
//					}
//					
//					
//				}
//			}
			//System.out.println(tmpans);
			go(0,0);
			
			
			for(int r = 0; r < N; r++) {
				arr[r] = cmap[r].clone();
			}
			
			
			
			
//			System.out.println();
//			System.out.println();
//			for(int r = 0; r < N; r++) {
//				for(int c = 0; c < M; c++) {
//					System.out.print(arr[r][c] + " ");
//				}
//				System.out.println();
//			}
			
			
			
			i++;
			
		}
		
		System.out.println(i);
		System.out.println(list.get(i-1));
		
	} // main
	
	static void go(int row, int col) {
		
		visited[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			
			int nextrow = row + drow[i];
			int nextcol = col + dcol[i];
			
			if(nextrow >=0 && nextrow < N && nextcol >= 0 && nextcol < M && arr[nextrow][nextcol] == 0 && !visited[nextrow][nextcol]) {
//				System.out.println( "go:  "+nextrow + " " + nextcol);
//				cmap[nextrow][nextcol] = 0;
				
				go(nextrow, nextcol);
				//arr[row][col] = 0;
				//visited[row][col] = true;
			}
			else if(nextrow >=0 && nextrow < N && nextcol >= 0 && nextcol < M && arr[nextrow][nextcol] == 1 && !visited[nextrow][nextcol]){
				cmap[nextrow][nextcol] = 0;
			}
			
			
		}
		
		
		
	} //go
	
	
	
}

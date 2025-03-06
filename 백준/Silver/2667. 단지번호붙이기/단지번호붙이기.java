import java.util.*;
import java.io.*;

public class Main {
	
	static List<Integer> list;
	static boolean[][] visited;
	static int[][] arr;
	static int ans = 0;
	static int[] drow = {0,0,1,-1};   // 좌 우 상 하
	static int[] dcol = {-1,1,0,0};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		visited = new boolean[N][N];
		arr = new int[N][N];
		
		for(int i = 0;i < N; i++) {
			String str = br.readLine();
			for(int chk = 0; chk < str.length(); chk++) {
				arr[i][chk] = Integer.parseInt(String.valueOf(str.charAt(chk)));
			}
			
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && arr[i][j] != 0) {
					ans = 0;
					go(i,j);
					list.add(ans);
				}
			}
		}
		
		System.out.println(list.size());
        Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
			
	}// main
	
	
	private static void go(int row, int col) {
		
		visited[row][col] = true;
		ans++;
		
		for(int i = 0; i < 4; i++) {
			int nextrow = row + drow[i];
			int nextcol = col + dcol[i];
			
			if(nextrow >= 0 && nextrow < N && nextcol >= 0 && nextcol < N && !visited[nextrow][nextcol] && arr[nextrow][nextcol] == 1) {
				go(nextrow, nextcol);
			}	
			
		}
		
	}
	
}
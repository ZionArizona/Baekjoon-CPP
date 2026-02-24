import java.util.*;
import java.io.*;


public class Main {

	static class locate{
		Character al;
		int row;
		int col;

		private locate(Character al, int row, int col) {
			this.al = al;
			this.row = row;
			this.col = col;
		}
		
	}
	
	static char[][] map;
	static List<locate> location = new ArrayList<>();
	static int[] hit;
	static int[] playerDis;
	static boolean vis[][];
	static int m;
	static int n;
	static int bossHealth;
	static int Brow;
	static int Bcol;
	static int[] drow = {-1,0,1,0};
	static int[] dcol = {0,-1,0,1};
	static int answer = 0;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		map = new char[m][n];
		hit = new int[27];
		playerDis = new int[27];
		Arrays.fill(playerDis, -1);
		
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] >= 97 && map[i][j] < 123) {
					location.add(new locate(map[i][j],i,j));
				}
				if(map[i][j] == 'B') {
					Brow = i;
					Bcol = j;
				}
			}
		}
//		System.out.println();
//		System.out.println("Brow : " + Brow + " Bcol : " + Bcol);
//		System.out.println();
		for(int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			hit[st.nextToken().charAt(0) - 'a'] = Integer.parseInt(st.nextToken());
		}
		
		Collections.sort(location, (e1,e2)->{
			return e1.al - e2.al;
		});
		
		bossHealth = Integer.parseInt(br.readLine());
//		System.out.println();
//		System.out.println();
		
//		for(int i = 0; i < m; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//			
//		}
		
		
		for(locate l : location) {
			//System.out.println("location " + l.al + " row : " + l.row + " col : " + l.col);
			bfs(l);
		}
		
		
//		for(int i = 0; i < playerDis.length; i++) {
//			if(playerDis[i] != -1) {
//				System.out.println((char)(i+'a') + " " + playerDis[i]);
//			}
//		}
		
		game();

		System.out.println(answer);
	}
	
	static void game() {
		Queue<int[]> que = new ArrayDeque<>();
		
		for(int i = 0; i < playerDis.length; i++) {
			if(playerDis[i] != -1) {
				que.add(new int[] {i,playerDis[i]});
//				System.out.println((char)(i+'a') + " " + playerDis[i]);
			}
		}
		
		
		while(bossHealth > 0) {
			
			int size = que.size();
			
			while(size > 0) {
				size--;
				int[] node = que.poll();
				int Nodenum = node[0];
				int Nodedis = node[1];
				
				if((Nodedis-1) == 0) {
					answer += 1;
					bossHealth -= hit[Nodenum];
					que.add(new int[] {Nodenum,Nodedis-1});
				}
				else if((Nodedis - 1) < 0){
					bossHealth -= hit[Nodenum];
					que.add(new int[] {Nodenum,Nodedis-1});
				}
				else if((Nodedis - 1) > 0){
					que.add(new int[] {Nodenum,Nodedis-1});
				}
			}
			
		}
		
	}
	
	static void bfs(locate node) {
		
		Queue<int[]> que = new ArrayDeque<>();
		vis = new boolean[m][n];
		vis[node.row][node.col] = true;
		que.add(new int[]{node.al,node.row, node.col, 0});
		
		while(!que.isEmpty()) {
			
			int[] xy = que.poll();
			
			int alpha = xy[0];
			int r = xy[1];
			int c = xy[2];
			int d = xy[3];
			
			for(int i = 0; i < 4; i++) {
				int nx = r + drow[i];
				int nc = c + dcol[i];
				
				if(nx >= 0 && nx < m && nc >= 0 && nc < n && nx == Brow && nc == Bcol) {
					playerDis[alpha - 'a'] = d+1;
					return;
				}
				if(nx >= 0 && nx < m && nc >= 0 && nc < n) {
					
					if(vis[nx][nc]) continue;
					if(map[nx][nc] == 'X') continue;
					vis[nx][nc] = true;

					que.add(new int[] {alpha,nx,nc,d+1});
				}
			}
			
		}
		
	}
	
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] D;
	static int[][] arr;
	static int[] drow = {-1,1,0,0};  // 상  하  좌   우
	static int[] dcol = {0,0,-1,1};
	
	
	static private class Edge implements Comparable<Edge>{
		
		int row, col,weight;
		Edge(int row, int col, int weight){
			this.row = row;
			this.col = col;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {

			return Integer.compare(this.weight, o.weight);
		}
	
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int idx = 1;
		String num;
		while(!(num=br.readLine()).equals("0")) {
			N = Integer.parseInt(num);
			arr = new int[N][N];
			D = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = Diq(0,0,arr[0][0]);
	
			sb.append("Problem ").append(idx).append(": ").append(ans).append("\n");
			
			idx++;
		}
		System.out.println(sb);
		
	} // main
	
	
	static int Diq(int row, int col, int num) {
		
		PriorityQueue<Edge> que = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(D[i], Integer.MAX_VALUE);
		}
		
		D[row][col] = num;
		
		que.offer(new Edge(row,col, num));
		
		
		while(!que.isEmpty()) {
			
			Edge e = que.poll();
			
			int r = e.row;
			int c = e.col;
			
			
			for(int i = 0; i < 4; i++) {
				
				int nextrow = r + drow[i];
				int nextcol = c + dcol[i];
				
				
				if(nextrow < 0 || nextcol < 0 || nextrow >= N || nextcol >= N) continue;
				
				if(D[nextrow][nextcol] > e.weight + arr[nextrow][nextcol]) {
					D[nextrow][nextcol] = e.weight + arr[nextrow][nextcol];
					que.offer(new Edge(nextrow, nextcol, D[nextrow][nextcol]));
				}
	
			}

		} // while

		return D[N-1][N-1];
	}

}
import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int[] arr;
	static boolean[] vis;
	static List<List<Edge>> list;
	static List<Integer> ans;
	static int chk;
	static boolean[] check;
	static int result;
	
	static private class Edge{
		int to;
		int weight;
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			
			list.add(new ArrayList<>());
			
		}

		
		for(int i = 0; i < N-1; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Edge(to, weight));
			list.get(to).add(new Edge(from, weight));
			
			
		}
		
		
		for(int i = 0; i < M; i++) {
			
			vis = new boolean[N+1]; 
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			result = 0;
			
			dfs(from, to,0);
			System.out.println(result);
		}
		
		
	} //main
	
	
	static void dfs(int start, int end,int cost) {
		vis[start] = true;
		
		if(start == end) {
			result = cost;
			return;
		}
		
		
		for(Edge edge : list.get(start)) {
			
			if(!vis[edge.to]) {
				dfs(edge.to, end, cost+edge.weight);
			}
			
		}
		
		//System.out.println(result);
		
	} //dfs
	
}
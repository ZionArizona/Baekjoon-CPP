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
	
	static int V, E;
	static int start;
	static List<List<Edge>> adj;
	static int[] D;
	
	static private class Edge implements Comparable<Edge>{
		
		int to, weight;
		Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {

			return Integer.compare(this.weight, o.weight);
		}
	
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		D = new int[V+1];
		
		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;
		adj = new ArrayList<>();
		
		for(int i = 0; i <= V; i++) {
			adj.add(new ArrayList<>());
		}
		
		
		for(int i = 0; i < E; i++) {
			
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adj.get(from).add(new Edge(to, weight));
	
		}
		
		Dijkstra(start);
		
		for(int i = 1; i <= V; i++) {
			if(D[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}
			else {
				sb.append(D[i]).append("\n");
			}
		}
		System.out.println(sb);
		
	} // main
	
	private static void Dijkstra(int start) {
		
		PriorityQueue<Edge> que = new PriorityQueue<>();
		que.add(new Edge(start,0));
		
		
		while(!que.isEmpty()) {
			Edge cur = que.poll();
			
			int u = cur.to;
			int d = cur.weight;
			
			if(d > D[u]) continue;
			
			for(Edge e : adj.get(u)) {
				if(D[u] + e.weight < D[e.to]) {
					D[e.to] = D[u] + e.weight;
					que.add(new Edge(e.to, D[e.to]));
				}
			}		
			
		}	
		
	} // Dijkstra

}
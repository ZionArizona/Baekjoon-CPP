import java.util.*;
import java.io.*;

public class Main {
	
	static private class Edge{
		
		int from, to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	
	static List<Edge> list;
	static int V, E;
	static int[] parents;
	
	
	static void make() {
		parents = new int[V+1];
		for(int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		
		if(a == parents[a]) return parents[a];
		return parents[a] = find(parents[a]);
		
	}
	
	static boolean union(int a, int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Edge(from,to,weight));
			
		}
		
		make();
		Collections.sort(list,(e1,e2)->{
			return Integer.compare(e1.weight, e2.weight);
		});
		
		int result = 0;
		int cnt = V;
		
		for(Edge e : list) {
			if(union(e.from, e.to)) {
				result += e.weight;
				if(--cnt == 1) {
					break;
				}
			}
		}
		
		System.out.println(result);
		
	}
}
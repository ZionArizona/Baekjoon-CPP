import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int V;
	static int start;
	static List<List<Integer>> list;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		list = new ArrayList<List<Integer>>();
		vis = new boolean[N+1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			list.get(c1).add(c2);
			list.get(c2).add(c1);
			
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}
		
		dfs(start);
		System.out.println();
		bfs(start);
		
	} // main
	
	static void dfs(int startNode) {
		
		vis[startNode] = true;
		System.out.print(startNode + " ");
		
		
		for(int i = 0; i < list.get(startNode).size(); i++) {
				
			if(!vis[list.get(startNode).get(i)]) {
				
				dfs(list.get(startNode).get(i));
				
			}
			
		}
		
	} //dfs
	
	static void bfs(int startNode) {
		
		Queue<Integer> que = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		que.offer(startNode);
		visited[startNode] = true;
		System.out.print(startNode +  " ");
		while(!que.isEmpty()) {
			
			int cur = que.poll();
			
			for(int i = 0; i < list.get(cur).size(); i++) {
				
				int next = list.get(cur).get(i);
				if(!visited[next]) {
					System.out.print(next + " ");
					visited[next] = true;
					que.offer(next);
				}
				
			}
			
		}
		
	} //bfs
	
}
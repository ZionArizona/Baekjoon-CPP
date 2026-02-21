import java.util.*;
import java.io.*;


public class Main {
	
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] vis;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int node = Integer.parseInt(br.readLine());
		int line = Integer.parseInt(br.readLine());
		
		vis = new boolean[node+1];
		
		for(int i = 0; i <= node; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
			
		}
		
		dfs(1);
		
		System.out.println(answer-1);
		
	}
	
	static void dfs(int node) {
		answer++;
		vis[node] = true;
		
		for(Integer n : list.get(node)) {
			if(vis[n] != true) {
				dfs(n);
			}
		}
		
	}

}

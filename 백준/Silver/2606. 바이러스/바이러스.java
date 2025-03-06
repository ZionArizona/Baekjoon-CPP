import java.util.*;
import java.io.*;

public class Main {
	
	static List[] com;
	static boolean[] visited;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		int connect = Integer.parseInt(br.readLine());
		
		visited = new boolean[num+1];
		com = new List[num+1];
		
		
		for(int i = 0; i < num+1; i++) {
			com[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < connect; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			com[a].add(b);
			com[b].add(a);
			
		}
		
		go(1);
		
		System.out.println(ans - 1);
			
	}// main
	
	
	private static void go(int vertext) {
		
		if(!visited[vertext]) {
			visited[vertext] = true;
			
			ans++;
			for(int i = 0; i < com[vertext].size(); i++) {
				go((int)com[vertext].get(i));
			}
			
			
		}
		
		
	}
	
}
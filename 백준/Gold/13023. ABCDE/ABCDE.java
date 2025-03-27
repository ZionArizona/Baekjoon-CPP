import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] vis;
	static boolean flag;
	static int ans;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			list.get(n1).add(n2);
			list.get(n2).add(n1);
			
		}
		
		
		for(int i = 0; i < N; i++) {
			vis = new boolean[N];
			flag = false;
			dfs(i,0);
			if(flag == true) break;
		}
		
		
		if(flag == true) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	} //main
	
	static void dfs(int node, int depth) {
		
		if(depth == 4) {
			flag = true;
			return;
		}
		
		vis[node] = true;
		
		for(Integer I : list.get(node)) {
			
			if(!vis[I]) {
				vis[I] = true;
				//System.out.println(depth);
				dfs(I,depth+1);
				vis[I] = false;
			}
		}
		
		if(flag==true) return;
		
	} //dfs
	
}
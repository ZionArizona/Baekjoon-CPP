import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int M;
	static List<List<Integer>> list;
	static List<Integer> result;
	static int[] indegree;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<List<Integer>>();
		result = new ArrayList<>();
		indegree = new int[N+1];
		
		for(int i = 0 ; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			indegree[c1]++;
			list.get(c2).add(c1);
			
		}
		
		topologySort();
		
		Collections.reverse(result);
		
		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
		
	} // main
	

	private static void topologySort(){
		Queue<Integer> que = new LinkedList<>();
		
		// 전입 노드가 0인 노드 큐 입력
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				que.offer(i);
			}
		}
		
		while(!que.isEmpty()) {
			
			int current = que.poll();
			//System.out.println(current);
			result.add(current);
			
			for(int i = 0; i < list.get(current).size(); i++) {
				
				indegree[list.get(current).get(i)]--;
				
				if(indegree[list.get(current).get(i)] == 0) {
					que.offer(list.get(current).get(i));
				}
				
			}
			
		}
		
	}  // topologySort
	
}
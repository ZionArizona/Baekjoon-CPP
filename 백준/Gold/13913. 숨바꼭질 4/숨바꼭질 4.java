import java.util.*;
import java.io.*;


public class Main {
	
	static int[] prv;
	static int[] dis;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		vis = new boolean[100001];
		prv = new int[100001];
		dis = new int[100001];
		
		for(int i = 0; i <= 100000; i++) {
			prv[i] = -1;
		}
		
		for(int i = 0; i <= 100000; i++) {
			dis[i] = -1;
		}
		
		bfs(x,y);
		
		System.out.println(dis[y]);
		
		List<Integer> list = new ArrayList<>();
		
//		System.out.println();
//		System.out.println();
//		System.out.println();
		
//		for(int i = 0; i <= 20; i++) {
//			System.out.print(prv[i] + " ");
//		}
		
		
		int cur = y;

		while (cur != -1) {
		    list.add(cur);
		    cur = prv[cur];
		}
		
		Collections.reverse(list);
		
		//System.out.println();
		
		for(Integer num : list) {
			System.out.print(num + " ");
		}
		
	}
	
	static void bfs(int cur, int fin) {
		
		Queue<Integer> que = new ArrayDeque<>();
		vis[cur] = true;
		dis[cur] = 0;
		prv[cur] = -1;
		
		que.add(cur);
		
		while(!que.isEmpty()) {
			
			int current = que.poll();
			
			if(current == fin) break;
			
			if(current -1 >= 0 && vis[current-1] != true) {
				vis[current-1] = true;
				dis[current-1] = dis[current] + 1;
				prv[current-1] = current;
				que.add(current-1);
			}
			
				
			if(current +1 < 100001 && vis[current+1] != true) {
				vis[current+1] = true;
				dis[current+1] = dis[current] + 1;
				prv[current+1] = current;
				que.add(current+1);	
			}
			
				
			if(current *2 < 100001 && vis[current*2] != true) {
				vis[current*2] = true;
				dis[current*2] = dis[current] + 1;
				prv[current*2] = current;
				que.add(current*2);			
			}

			
		}
		
	}

}

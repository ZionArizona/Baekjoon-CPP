import java.util.*;
import java.io.*;

class Main {
	
	static int[] num;
	static boolean[] visit;
	static int M;
	static int N;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		visit = new boolean[M+1];
		
		Permutation(0);
		
		System.out.println(sb);
		
		
	}//main
	
	public static void Permutation(int cnt) {
		
		if(cnt == N) {
			for(int i = 0; i < num.length; i++) {
				sb.append(num[i] + " ");
			}
			
			sb.append("\n");
			return;
		}
		
		
		for(int i = 1; i <= M; i++) {
			if(visit[i]) continue;
			
			num[cnt] = i;
			visit[i] = true;
			Permutation(cnt+1);
			visit[i] = false;
		
		}
		
	}
}
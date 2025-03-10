import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] arr;
	static char[] operation;
	static boolean[] visited;
	static StringBuilder sb;
	static int Max;
	static int Min;
	static List<Character> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		operation = new char[N];
		Max = Integer.MIN_VALUE;
		Min = Integer.MAX_VALUE;
		list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			for(int c = 0; c < num; c++) {
				if(i == 0) {
					list.add('+');
				}
				else if(i == 1) {
					list.add('-');
				}
				else if(i == 2) {
					list.add('*');
				}
				else {
					list.add('/');
				}
			}
		}
		visited = new boolean[list.size() + 1];
		
		Permutation(0);
		System.out.println(Max);
		System.out.println(Min);
		
	} // main
	
	static void Permutation(int depth) {
		
		if(depth == N-1) {
			int ans = arr[0];
			for(int i = 0; i < N-1; i++) {
				if(operation[i] == '+') {
					ans += arr[i+1];
				}
				else if(operation[i] == '-') {
					ans -= arr[i+1];
				}
				else if(operation[i] == '*') {
					ans *= arr[i+1];
				}
				else {
					ans /= arr[i+1];
				}
			}
			
			Max = Math.max(ans, Max);
			Min = Math.min(ans, Min);
			
			return;
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			operation[depth] = list.get(i);
			Permutation(depth+1);
			visited[i] = false;
			
		}
		
	} //Permutation

}
import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		Permutation(1,0);
		System.out.println(sb);
		
	} // main
	
	static void Permutation(int start, int depth) {
		
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			
			sb.append("\n");
			
			return;
		}
		
		for(int i = start; i <= N; i++) {
			
			arr[depth] = i;
			Permutation(i, depth+1);
			
		}
		
	} //Permutation

}
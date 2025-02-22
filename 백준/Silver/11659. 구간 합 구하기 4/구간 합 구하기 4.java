import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb;
	static int[] arr;
	static int[] sum;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		sum = new int[N+1];
		arr[0] = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sum[0] = arr[0];
		
		for(int i = 1; i <= N; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		
		
		for(int t = 0; t < M; t++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			ans = sum[end] - sum[start-1];
			
			sb.append(ans + "\n");
		}
		
		System.out.println(sb);
		
	} // main
	
}
import java.util.*;
import java.io.*;

public class Main {
	
	static int N,K;
	static int[] arr;
	static int[] drow = {-1,0,0,1};  // 상   우   좌   하 
	static int[] dcol = {0,1,-1,0};
	static boolean[][] vis;
	static StringBuilder sb;
	static long ans;
	static int homex;
	static int homey;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		ans = Integer.MIN_VALUE;
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long left = 1;
		long right = arr[K-1];
		
		while(left <= right) {
			
			long mid = (left + right)/2;
			
			long sum = 0;
			for(int i = 0; i < K; i++) {
				sum += (arr[i]/mid);
			}
			
			if(sum >= N) {
				ans = Math.max(ans, mid);
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
			
		} //while
		
		System.out.println(ans);
	} // main
	
}
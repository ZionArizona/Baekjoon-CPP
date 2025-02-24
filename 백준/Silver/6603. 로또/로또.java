import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static StringBuilder sb;
	static int[] arr;
	static int[] num;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb  = new StringBuilder();
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			num = new int[7];
			//System.out.println(N);
			if(N == 0) {
				break;
			}
			
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); 
			}
			
			com(0,0);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	} //main
	
	
	static public void com(int cnt, int start) {
		
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				//System.out.print(num[i] + " ");
				sb.append(num[i] + " ");
				
			}
			//System.out.println();
			sb.append("\n");
			return;
		}
		
		
		
		for(int i = start; i < N; i++) {
			
			num[cnt] = arr[i];
			com(cnt+1, i+1);
			
		}
		
		
		
		
	}
	
	
	
}

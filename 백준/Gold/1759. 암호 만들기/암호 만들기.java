import java.util.*;
import java.io.*;

public class Main {
	
	static int L, C;
	static String[] arr;
	static boolean[] vis;
	static String[] input;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		vis = new boolean[L];
		arr = new String[C];
		input = new String[L];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr);
		
		// 조합
		go(0,0);
		
	} // main
	
	static void go(int start, int depth){
		
		if(depth == L) {
			int cntJa = 0;
			int cntMo = 0;
			
			for(int i = 0; i < L; i++) {
				if(input[i].equals("a") || input[i].equals("e") || input[i].equals("i") || input[i].equals("o") || input[i].equals("u")) {
					cntMo++;
				}
				else {
					cntJa++;
				}
				
			}
			
			if(cntMo >= 1 && cntJa >= 2) {
				
				for(int i = 0; i < L; i++) {
					System.out.print(input[i]);
				}
				System.out.println();
			}
			else {
				return;
			}
			
			return;
		}
		
		for(int i = start; i < C; i++) {
			
			input[depth] = arr[i];
			go(i+1,depth+1);
				
		}
		
	} //go
	
}
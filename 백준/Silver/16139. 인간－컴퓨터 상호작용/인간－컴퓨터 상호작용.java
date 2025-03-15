import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[26][str.length()+1];
		
		
		for(char a = 0; a < 26; a++) {
			
			char chk = (char)('a' + a);
			arr[a][0] = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == chk) {
					if(i == 0) {
						arr[a][i] = 1;
					}
					else {
						arr[a][i] = arr[a][i-1] + 1;
					}
					
				}
				else {
					if(i == 0) {
						arr[a][i] = 0;
					}
					else {
						arr[a][i] = arr[a][i-1];
					}
				}
				
			}
			
		}
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int c = st.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			
			if(start == 0) {
				sb.append(arr[c][end]);
			}
			else {
				sb.append(arr[c][end] - arr[c][start-1]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	} // main
	
}
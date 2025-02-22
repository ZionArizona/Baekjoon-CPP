import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb;
	static boolean[] isSelected;
	static int[] aci;
	static int[] sour;
	static int N;
	static long Min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		aci = new int[N];
		sour = new int[N];
		isSelected = new boolean[N];
		Min = Long.MAX_VALUE;
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st	= new StringTokenizer(br.readLine());
			aci[i] = Integer.parseInt(st.nextToken());
			sour[i] = Integer.parseInt(st.nextToken());
		}
		
	
		
		
		Subset(0,0);
		sb.append(Min);
		System.out.println(sb);
		
	} // main
	
	
	public static void Subset(int cnt, int pickCnt) {
		
		if(cnt == N) {
			
			long ansAci = 1;
			long ansSour = 0;
			boolean flag = false;
			for(int i = 0; i < N; i++) {
				if(isSelected[i] == true) {
				//System.out.println(aci[i] + "  " + sour[i]);
					ansAci *= aci[i];
					ansSour += sour[i];
					flag = true;
				}
			}
			
			
			if(flag == true) {
				Min = Math.min(Min, Math.abs(ansAci - ansSour));
			}
			
			
			return;
		}
		
		isSelected[cnt] = true;
		Subset(cnt+1,pickCnt + 1);
		isSelected[cnt] = false;
		Subset(cnt+1, pickCnt);
		
	}// combination
	
}
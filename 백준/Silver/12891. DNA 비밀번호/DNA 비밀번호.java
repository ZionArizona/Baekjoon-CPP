import java.util.*;
import java.io.*;

public class Main {
	
	static int S;
	static int P;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		
		
		int[] arr = new int[4]; // A    C     G    T
		
		for(int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int ans = 0;

		int cntA = 0;
		int cntC = 0;
		int cntG = 0;
		int cntT = 0;
		
		// 처음 P만킁 크기 탐색
		for(int i = 0; i < P; i++) {
			
			if(str.charAt(i) == 'A') {
				cntA++;
			}
			else if(str.charAt(i) == 'C') {
				cntC++;
			}
			else if(str.charAt(i) == 'G') {
				cntG++;
			}
			else if(str.charAt(i) == 'T') {
				cntT++;
			}
			
			
		}
		
		if(((cntA + cntC + cntG + cntT) >= P ) && (cntA >= arr[0]) && (cntC >= arr[1]) && (cntG >= arr[2]) && (cntT >= arr[3])) {
			ans++;
		}
		
		int idx = 0;
		
		for(int i = P; i < str.length(); i++) {
			
			// 슬라이싱 할때 왼쪽
			char chkL = str.charAt(idx);
			idx += 1;
			
			// 슬라이싱 할때 오른쪽
			char chkR = str.charAt(i);
			
			
			if(chkL == 'A') {
				cntA--;
			}
			else if(chkL == 'C') {
				cntC--;
			}
			else if(chkL == 'G') {
				cntG--;
			}
			else if(chkL == 'T') {
				cntT--;
			}
			
			
			if( chkR == 'A') {
				cntA++;
			}
			else if( chkR == 'C') {
				cntC++;
			}
			else if(chkR == 'G') {
				cntG++;
			}
			else if(chkR == 'T') {
				cntT++;
			}
			
			
			if(((cntA + cntC + cntG + cntT) >= P ) && (cntA >= arr[0]) && (cntC >= arr[1]) && (cntG >= arr[2]) && (cntT >= arr[3])) {
				ans++;
				
			} // if
			
		}
		
		
		System.out.println(ans);
		
		
	} // main
	
}
import java.util.*;
import java.io.*;

class Main {
	
	static int N,R;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb;
	static String[] strA;
	static long Max;
	static long Min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		strA = br.readLine().split(" ");
		
		Max = Long.MIN_VALUE;
		Min = Long.MAX_VALUE;
		
		
		sb = new StringBuilder();
		
		// 10개 중 선 택해야하는 것은 N+1
		
		//N = Integer.parseInt(st.nextToken());
		R = N + 1;
		
		numbers = new int[R];  // 선택된 수 저장
		isSelected = new boolean[10];  // 1부터 사용, 선택 여부 저장
		
		permutation(0);
		
		
		if(String.valueOf(Max).length() != (N+1)) {
			System.out.println("0" + String.valueOf(Max));
		}
		else {
			System.out.println(String.valueOf(Max));
		}
		
		if(String.valueOf(Min).length() != (N+1)) {
			System.out.println("0" + String.valueOf(Min));
		}
		else {
			System.out.println(String.valueOf(Min));
		}

		
		
	}//main
	
	static void permutation(int cnt) {
		
		//기저
		if(cnt == R) {
			chk();
			return;
		}
		
		
		for(int i = 9; i >= 0;i--) {  // 유도파트
			if(isSelected[i]) continue;
			numbers[cnt] = i;   //선택한 수 저장
			isSelected[i] = true;  // 선택한  수 플래그 true
			permutation(cnt+1);    // 다음수 선택하러 고고씽!
			isSelected[i] = false;  // 선택을 변경해야하므로 기존 플래그 원복
			
		}
		
	} //permutation
	
	static void chk() {
				
		
//		for(int i = 0; i < numbers.length; i++) {
//			System.out.print(numbers[i] + " ");
//		}
//		System.out.println();
		
		
		String strChk = "";
		
		for(int i = 0; i < N; i++) {
			if(strA[i].equals("<")) {
				if(numbers[i] < numbers[i+1]) {
					strChk += String.valueOf(numbers[i]);
				}
				else {
					//System.out.println("1");
					return;
				}
			}
			else if(strA[i].equals(">")){
				if(numbers[i] > numbers[i+1]) {
					strChk += String.valueOf(numbers[i]);
				}
				else {
					//System.out.println("2");
					return;
				}
			}
			
			//System.out.println(strChk);
		}
		strChk += String.valueOf(numbers[N]);			
		
		Max = Math.max(Max, Long.parseLong(strChk));
		Min = Math.min(Min, Long.parseLong(strChk));
		
		
	} // chk
	
	
}

import java.util.*;
import java.io.*;


public class Main {
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		
		while(N>0) {
			
			if(N%10 == 6) {
				arr[9]++;
			}
			else {
				arr[N%10]++;
			}
			
			
			N /= 10;
			
		}
		
		
		if(arr[9] %2 == 0) {
			arr[9] = arr[9]/2;
		}
		else {
			arr[9] = arr[9]/2+1;
		}
		
		
		int maxNum = Integer.MIN_VALUE;
		for(int i = 0; i < 10; i++) {
			//System.out.println(i + " : " + arr[i]);
			if(arr[i] == 0) continue;
			
			maxNum = Math.max(maxNum, arr[i]);
			
		}
			
		System.out.println(maxNum);
		
	}

}

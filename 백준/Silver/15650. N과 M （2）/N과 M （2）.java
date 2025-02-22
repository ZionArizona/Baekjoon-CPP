import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb;
	static int[] numbers;
	static int[] input;
	static int N;
	static int M;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		input = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		
		Combination(0,0);
	} // main
	
	
	public static void Combination(int cnt, int start) {
		
		if(cnt == M) {
			for(int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			Combination(cnt+1, i+1);
		}
		
	}// Permutation
}
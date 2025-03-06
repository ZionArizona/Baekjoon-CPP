import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] arr;
	static int N;
	static int r;
	static int c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		
		int ans = go(N,r,c);
		
		System.out.println(ans);
		
		
			
	}// main
	
	
	static int go(int num, int row, int col) {
		
		if(num == 0) return 0;
		
		
		int width = 1 << (num - 1);
		int Area = width*width;
		
		
		if(row < width && col < width) {
			
			//1 사분몆
			return go(num-1, row, col);
			
		}
		else if(row < width && col >= width) {
			
			//2사분면
			return Area + go(num - 1, row, col-width);
			
		}
		else if(row >= width && col < width) {
			
			//3사분면
			return Area*2 + go(num-1, row - width, col);
			
		}
		else {
			
			//4사분면
			return Area*3 + go(num-1, row - width, col - width);
			
		}
		
	} //go
	
}
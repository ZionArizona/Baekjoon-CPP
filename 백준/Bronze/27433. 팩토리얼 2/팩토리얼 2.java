import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		System.out.println(fac(N));
		
	} // main
	
	static long fac(int N) {
		
		if(N == 0 || N == 1) return 1;
		
		return N * fac(N-1);
	}
	
}
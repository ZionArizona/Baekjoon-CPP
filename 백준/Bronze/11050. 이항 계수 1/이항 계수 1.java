import java.util.*;
import java.io.*;

public class Main {
	
	static int N,K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(fac(N,K));
		
	} // main
	
	
	static int fac(int N, int K) {
		
		if(K == 0 || N == K) {
			return 1;
		}
		
		return fac(N-1, K-1) + fac(N-1, K);
	} // fac
	
}
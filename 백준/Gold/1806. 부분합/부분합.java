import java.util.*;
import java.io.*;


public class Main
{
	public static void main(String[] args) throws IOException{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int S = Integer.parseInt(st.nextToken());
	    
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
	    
	    int l = 0;
	    int r = 0;
	    
	    int len = Integer.MAX_VALUE;
	    int sum = 0;
	    
	    while(r < N){
	        sum += arr[r];
	        
	        
	        while(sum >= S){
	            len = Math.min(len, r-l+1);
	            sum -= arr[l];
	            l++;
	        }
	        r++;
	   }
	        
	   if(len == Integer.MAX_VALUE){
	       System.out.println(0);
	   }
	   else{
	       System.out.println(len);
	   }
	    
	}
}

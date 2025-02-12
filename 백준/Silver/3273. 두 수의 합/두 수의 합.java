import java.util.*;
import java.io.*;

public class Main
{
    
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
		
	    Arrays.sort(arr);	
		
		int li = 0;
		int ri = N-1;
		int ans = 0;
		while(li < ri){
		    if((arr[li] + arr[ri]) == M){
		        ans++;
		    }
		    
		    if((arr[li] + arr[ri]) < M){
		        li++;
		    }
		    else{
    		    ri--;
		    }
		    
		}
		
        System.out.println(ans);		
		
	}
}

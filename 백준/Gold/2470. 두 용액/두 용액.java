import java.util.*;
import java.io.*;


public class Main
{
	public static void main(String[] args) throws IOException{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
	    
	    long ans = Integer.MAX_VALUE;
	    
	    Arrays.sort(arr);
	    
	    int lt = 0;
	    int rt = N-1;
	    long anslt = 0;
	    long ansrt = 0;
	    
	    while(lt < rt){
	        
	        long sum = arr[lt] + arr[rt];
	        
	        //sum이 0과 가까운지 확인
	        long chk = Math.abs(arr[lt] + arr[rt]);
	        if(chk <= ans){
                anslt = arr[lt];
                ansrt = arr[rt];
                ans = chk;
	        }
	        
	        if(sum > 0){
	            rt--;
	        }
	        else{
	            lt++;
	        }
	    }
	    
        
	    if(anslt<ansrt){
		    System.out.println(anslt + " " + ansrt);
	    }
	    else{
		    System.out.println(ansrt + " " + anslt);
	        
	    }
	    
	}
}

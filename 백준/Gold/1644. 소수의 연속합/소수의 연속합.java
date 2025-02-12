import java.util.*;
import java.io.*;


public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    int target = N;
	    
        int[] arr = new int[N+1];
        boolean[] chk = new boolean[N+1]; //false
        
        for(int i = 2; i <= N; i++){
            arr[i] = i;
        }
        
        for(int i = 2; i <= (int)Math.sqrt(N); i++){
            if(chk[i] == false){
                for(int j = 2*i; j <= N; j+=i){
                    chk[j] = true;
                    arr[j] = 0;
                }
            }
            
        }    
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 2; i <= N; i++){
            if(arr[i] != 0){
                list.add(arr[i]);
            }
        }
        
        int[] arr1 = list.stream().mapToInt(i -> i).toArray();
        
        int l = 0;
        int r = 0;
        
        int sum = 0;
        int ans = 0;
        while(r < arr1.length){
            sum += arr1[r];
            
            while(sum >= target){
                if(sum == target) ans++;
                sum -= arr1[l];
                l++;
            }
            
            r++;
        }    
        
        
        System.out.println(ans);
        
        
        // for(int i = 0; i < arr1.length; i++){
        //     System.out.println(arr1[i]);
        // }
        
	}
}

import java.util.*;
import java.io.*;


public class Main
{
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int[] arr = new int[3];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        
        int ans = 0;
        if(a == b && b == c){
            ans = a+b+c;
        }
        else{
            while(c >= a+b){
                c--;;
            }
            
            ans = a+b+c;
        }
        //System.out.println(a + " " + b + " " +c);
        System.out.println(ans);
	}
}
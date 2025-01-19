import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String,String> name = new HashMap<>();
        Map<String, String> num = new HashMap<>();
        
        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            name.put(str,String.valueOf(i));
            num.put(String.valueOf(i),str);
        }
        
        for(int i = 0; i < M; i++){
            String str = br.readLine();
            
            
            if(isNumber(str)){
                System.out.println(num.get(str));
            }
            else{
                System.out.println(name.get(str));
            }
        }
        
	}
	
	public static boolean isNumber(String str){
	    return str.matches("\\d+");
	}
	
}

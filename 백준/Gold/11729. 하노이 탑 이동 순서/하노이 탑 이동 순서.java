import java.util.*;
import java.io.*;

public class Main
{
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    
		System.out.println((int)Math.pow(2,N)-1);
		Hanoi(N,1,2,3);
		System.out.println(sb);
		
	}
	
	static void Hanoi(int N, int start, int mid, int to) {
        if(N==1){
            sb.append(start + " " + to + "\n");
            return;
        }
    
    
        Hanoi(N-1,start,to,mid);
        sb.append(start + " " + to + "\n");
        Hanoi(N-1,mid,start,to);
        
	
	
    }
	
}

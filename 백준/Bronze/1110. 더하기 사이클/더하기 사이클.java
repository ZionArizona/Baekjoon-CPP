import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int chk = N;
        
        do{
            int back = chk % 10;
            int next = chk/10 + chk%10;
            ans++;  
            
            chk = 10*back + next%10;
            
        }while(chk != N);
            
        System.out.println(ans);    
            
    }
}
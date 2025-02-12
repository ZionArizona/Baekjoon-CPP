import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
            
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            
            int cnt = 0;
            int ans = 0;
            for(int j = 0; j < str.length(); j++){
                if(String.valueOf(str.charAt(j)).equals("O")){
                    ans += ++cnt;
                }
                else{
                    cnt = 0;
                }
            }
            
            System.out.println(ans);
        }    
    }
}
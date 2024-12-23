import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int ans = 0;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(str[i]);
            if(num == 2){
                ans++;
                continue;
            }
            if(num == 1){
                continue;
            }
            boolean chk = false;
            for(int j = 2; j < num; j++){
                if(num%j ==0){
                    chk = true;
                    break;
                }
            }
            if(chk == false){
                ans++;
            }
        }
        System.out.println(ans);
    }
}

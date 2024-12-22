import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int p = Integer.parseInt(str[0]);
        int q = Integer.parseInt(str[1]);

        int ans = 0;
        for(int i = 1; i <= p; i++){
            if(p%i == 0){
                ans++;
            }
            if(ans == q){
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);

    }
}

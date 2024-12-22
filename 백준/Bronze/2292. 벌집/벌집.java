import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int ans = 1;
        int i = 1;
        while(ans < T){
            ans += 6*i;
            i++;
        }
        System.out.println(i);
    }
}

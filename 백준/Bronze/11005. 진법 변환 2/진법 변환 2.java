import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        String ans1 = "";
        while(B <= N){
            int ans = N%B;
            N /= B;
            if(ans >= 10 && ans <= 35){
                ans1 += String.valueOf((char)(ans-10+65));
            }
            else{
                ans1 += String.valueOf(ans);
            }
        }

        if(N >= 10 && N <= 35){
            ans1 += String.valueOf((char)(N-10+65));
        }
        else{
            ans1 += String.valueOf(N);
        }

        ans1 = new StringBuilder(ans1).reverse().toString();
        System.out.println(ans1);

    }
}

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        String st = str[0];
        int N = Integer.parseInt(str[1]);

        int ans = 0;

        st = new StringBuilder(st).reverse().toString();

        for(int i = 0; i < st.length(); i++){
            if(st.charAt(i) >= 'A' && st.charAt(i) <= 'Z'){
                ans += ((st.charAt(i) - 'A') + 10) * Math.pow(N,i);
            }
            else{
                ans += (Integer.parseInt(String.valueOf(st.charAt(i)))) * Math.pow(N,i);
            }

        }
        System.out.println(ans);
    }
}

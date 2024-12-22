import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);

        int ans = 0;

        ans = (int)Math.ceil(((double)(V-A)/ (A-B))) + 1;


        System.out.println(ans);
    }
}

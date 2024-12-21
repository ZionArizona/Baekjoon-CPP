import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] chk = {1,1,2,2,2,8};
        String[] str = br.readLine().split(" ");

        int[] ans = new int[6];

        for(int i = 0; i < 6; i++){
            ans[i] = chk[i] - Integer.parseInt(str[i]);
        }

        for(int i = 0; i < 6; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

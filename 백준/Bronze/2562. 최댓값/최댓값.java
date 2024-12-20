import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int idx = 0;
        for(int i = 1 ; i <= 9; i++){
            int chk = Integer.parseInt(br.readLine());

            if(chk > max) {
                max = chk;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx);
    }
}

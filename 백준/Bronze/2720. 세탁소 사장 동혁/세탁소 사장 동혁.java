import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int chk = Integer.parseInt(br.readLine());
            System.out.print((chk/25) + " ");
            chk %= 25;
            System.out.print((chk/10) + " ");
            chk %= 10;
            System.out.print((chk/5) + " ");
            chk %= 5;
            System.out.println(chk + "");
        }
        ;
    }
}

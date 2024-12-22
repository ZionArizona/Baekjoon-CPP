import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int fir = 3;

        for(int i =1; i < T; i++){
            fir += Math.pow(2,i);
        }
        System.out.println((int)Math.pow(fir,2));
    }
}

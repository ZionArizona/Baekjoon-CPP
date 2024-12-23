import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int sum = 0;
        int fir = -1;

        for(int i = N; i <= M; i++){
            boolean chk = true;
            if(i == 1){
                continue;
            }
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i == 2){
                    sum += i;
                    if(fir == -1){
                        fir = i;
                    }
                }
                if(i%j == 0){
                    chk = false;
                }
            }
            if(chk == true){
                sum += i;
                if(fir == -1){
                    fir = i;
                }
            }
        }
        if(sum == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(fir);
        }
    }
}
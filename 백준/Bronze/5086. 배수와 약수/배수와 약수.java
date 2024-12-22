import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);

            if(A == 0 && B == 0){
                break;
            }

            if(A == B){
                System.out.println("factor");
            }
            if(A>B){
                if(A%B == 0){
                    System.out.println("multiple");
                }
                else{
                    System.out.println("neither");
                }
            }
            else{
                if(B%A == 0){
                    System.out.println("factor");
                }
                else{
                    System.out.println("neighter");
                }
            }
        }
    }
}

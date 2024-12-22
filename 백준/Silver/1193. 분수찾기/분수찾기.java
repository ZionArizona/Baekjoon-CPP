import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());


        if(X == 1){
            System.out.println(1 + "/" +1);
        }
        else{
            int dig = 0;
            int sum = 0;

            while(sum < X){
                dig++;
                sum += dig;
            }
            dig--;
            if(dig%2 == 0){
                int Asum = dig + 2;
                int up = Asum - 1;
                int down = 1;
                int count = X - (sum-dig);
                for(int i = 0; i < count; i++){
                    up--;
                    down++;
                }
                System.out.println(up + "/" + down);
            }
            else{
                int Asum = dig + 2;
                int up = 1;
                int down = Asum -1;
                int count = X - (sum -dig);
                for(int i = 0; i < count; i++){
                    up++;
                    down--;
                }
                System.out.println(up + "/" + down);
            }


        }
    }
}

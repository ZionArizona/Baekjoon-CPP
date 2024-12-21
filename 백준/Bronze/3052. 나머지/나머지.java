import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[42];

        for(int i = 0; i < 10; i++){
            int chk = Integer.parseInt(br.readLine());
            int rest = chk% 42;

            arr[rest]  = true;
        }

        int sum = 0;
        for(int i = 0; i < 42; i++){
            if(arr[i] == true){
                sum += 1;
            }
        }
        System.out.println(sum);

    }
}

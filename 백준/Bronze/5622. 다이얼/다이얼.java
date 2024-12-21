import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] arr = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,6,7,7,7,8,8,8,8};
        int sum = 0;

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            sum += arr[str.charAt(i) - 'A'];
        }

        sum += (2*str.length());

        System.out.println(sum);
    }
}

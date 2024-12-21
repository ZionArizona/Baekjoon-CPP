import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        String str = br.readLine();

        for(int i = 0 ; i < str.length(); i++){

            sum += str.charAt(i) - '0';

        }

        System.out.println(sum);

    }
}

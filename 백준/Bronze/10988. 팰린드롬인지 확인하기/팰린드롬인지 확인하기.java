import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int start = 0;
        int end = str.length() - 1;

        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                System.out.println(0);
                return;
            }
            start++;
            end--;

        }
        System.out.println(1);

    }
}

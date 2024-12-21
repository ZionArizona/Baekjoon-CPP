import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        String str1 = new StringBuilder(str[0]).reverse().toString();
        String str2 = new StringBuilder(str[1]).reverse().toString();
        

        System.out.println(Math.max(Integer.parseInt(str1),Integer.parseInt(str2)));


    }
}

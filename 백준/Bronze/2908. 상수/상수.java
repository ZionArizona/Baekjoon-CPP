import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        StringBuffer str1 = new StringBuffer(str[0]);
        StringBuffer str2 = new StringBuffer(str[1]);

        String str_1 = str1.reverse().toString();
        String str2_2 = str2.reverse().toString();

        System.out.println(Math.max(Integer.parseInt(str_1),Integer.parseInt(str2_2)));

    }
}

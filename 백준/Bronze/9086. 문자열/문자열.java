import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i< N; i++){
            String str = br.readLine();
            System.out.println(str.substring(0,1) + "" + str.substring(str.length()-1,str.length()-1+1) );
        }

    }
}

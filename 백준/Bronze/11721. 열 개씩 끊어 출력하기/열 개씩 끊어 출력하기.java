import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int cnt = 0;

        for(int i = 0; i < str.length(); i++){

            cnt++;
            sb.append(String.valueOf(str.charAt(i)));

            if(cnt % 10 == 0){
                sb.append("\n");
                cnt = 0;
            }

        }

        System.out.println(sb);

    } // main
}
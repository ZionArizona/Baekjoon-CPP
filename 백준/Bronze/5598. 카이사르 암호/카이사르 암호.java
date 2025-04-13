import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            char chk = str.charAt(i);

            int a = chk - 'D';

            char c;
            if(a < 0){
                c = (char)(a+26 + 65);
            }
            else{
                c = (char)(a+65);
            }

            System.out.print(c);
        }
    }

}
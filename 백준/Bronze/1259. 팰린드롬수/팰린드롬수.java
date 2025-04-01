import java.sql.Array;
import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String num = br.readLine();

            if(num.equals("0")) break;

            boolean chk = check(num);
            if(chk == true){
                sb.append("yes").append("\n");
            }
            else{
                sb.append("no").append("\n");
            }

        }

        System.out.println(sb);

    } //main

    private static boolean check(String num){

        int left = 0;
        int right = num.length() - 1;

        while(left < right){

            char le = num.charAt(left);
            char ri = num.charAt(right);

            if(le != ri) return false;

            left++;
            right--;
        }

        return true;
    } // check

}
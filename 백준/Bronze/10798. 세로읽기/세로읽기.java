import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] st = new String[5][15];

        for(int i = 0; i < 5; i++){
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++){
                st[i][j] = String.valueOf(str.charAt(j));
            }
        }

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                if(st[j][i] == null){
                    continue;
                }
                System.out.print(st[j][i]);
            }
        }
    }
}
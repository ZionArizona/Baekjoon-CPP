import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int col = 0;
        int row = 0;
        int Max = 0;

        for(int i = 0; i < 9; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < 9; j++){
                if(Integer.parseInt(str[j]) > Max){
                    Max = Integer.parseInt(str[j]);
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(Max);
        System.out.println((row + 1) + " " + (col + 1));
    }
}

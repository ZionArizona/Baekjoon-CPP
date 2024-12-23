import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());

        int x = 0;
        int y = 0;
        int left = 10001;
        int right = -10001;
        int bot = 10001;
        int top = -10001;

        for(int i = 0 ; i< N; i++){
            String[] str = br.readLine().split(" ");
            x = Integer.parseInt(str[0]);
            y = Integer.parseInt(str[1]);
            left = Math.min(left,x);
            right = Math.max(right,x);
            bot = Math.min(bot,y);
            top = Math.max(top,y);
        }
        System.out.println(Math.abs(left-right) * Math.abs(top-bot));
    }
}
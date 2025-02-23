import java.util.*;
import java.io.*;

public class Main {
    static String[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while((input = br.readLine()) != null){
            int N = Integer.parseInt(input);
            arr = new String[(int)Math.pow(3,N)];

            for(int i = 0; i < (int)Math.pow(3,N); i++){
                arr[i] = "-";
            }

            go(0,(int)Math.pow(3,N));

            
            StringBuilder sb = new StringBuilder();
            for (String s : arr) {
                sb.append(s);
            }
            System.out.println(sb);
        }

    }// main

    public static void go(int start, int num){
        // 기저
        if(num == 1){
            return;
        }

        //유도 부분
        int sec = start + num/3;
        int thr = start + (num/3)*2;
        for(int i = sec; i < sec + (num/3); i++){
            arr[i] = " ";
        }

        go(start, num/3);
        go(thr, num/3);

    } // go

}
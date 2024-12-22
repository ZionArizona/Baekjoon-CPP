import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int fir = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[fir][sec];
        int[][] arr2 = new int[fir][sec];

        for(int i = 0; i < fir; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < sec; j++){
                arr1[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int i = 0; i < fir; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < sec; j++){
                arr2[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i =0; i < fir; i++){
            for(int j = 0; j < sec; j++){
                System.out.print(arr1[i][j] + arr2[i][j] + " ");
            }
            System.out.println();
        }

    }
}

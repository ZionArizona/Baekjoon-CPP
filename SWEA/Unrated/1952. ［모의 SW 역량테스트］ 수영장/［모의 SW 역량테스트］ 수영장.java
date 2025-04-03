import java.sql.Array;
import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Solution {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] price = new int[4];
            int[] day = new int[13];
            int[] dp = new int[13];


            for(int i = 0; i < 4; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= 12; i++){
                day[i] = Integer.parseInt(st.nextToken());
            }
            dp[0] = 0;
            for(int i = 1; i <= 12; i++){

                int d = dp[i-1] + day[i] * price[0];
                int m = dp[i-1] + price[1];
                int y = 0;
                if(i >= 3){
                    y = dp[i-3] + price[2];
                }
                else{
                    y = price[2];
                }

                dp[i] = Math.min(d,m);
                dp[i] = Math.min(dp[i], y);

            }
            sb.append("#").append(test).append(" ").append(Math.min(dp[12],price[3])).append("\n");
        }


        System.out.println(sb);


    } //main

}
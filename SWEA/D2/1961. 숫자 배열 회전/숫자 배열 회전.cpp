import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int k = 1; k <= T; k++){
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for(int i = 0; i < N; i++){
                String[] str = br.readLine().split(" ");
                for(int j = 0; j < str.length; j++){
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }

            StringBuilder sb = new StringBuilder();

            int[][] arrOne = new int[N][N];
            int[][] arrTwo = new int[N][N];
            int[][] arrThree = new int[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arrOne[j][N-1-i] = arr[i][j];
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arrTwo[j][N-1-i] = arrOne[i][j];
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arrThree[j][N-1-i] = arrTwo[i][j];
                }
            }


            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    sb.append(arrOne[i][j]);
                }

                sb.append(" ");

                for(int j = 0; j < N; j++){
                    sb.append(arrTwo[i][j]);
                }

                sb.append(" ");

                for(int j = 0; j < N; j++){
                    sb.append(arrThree[i][j]);
                }

                sb.append("\n");



            }
                System.out.println("#" + k);
                System.out.print(sb);



        }



    }
}

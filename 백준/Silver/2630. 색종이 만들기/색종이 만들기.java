import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        div(0,0, N);

        System.out.print(white + "\n" + blue);

    }// main

    public static void div(int row, int col, int num){
        if(chkColor(row,col,num)){ //사각형 검사했는데 모두 같은 색일 경우
            if(arr[row][col] == 0){
                white++;
            }
            else{
                blue++;
            }

            return;

        }

        // if문을 모두 만족하지 못하면
        int move = num/2;
        div(row, col, move);
        div(row + move, col, move);
        div(row, col + move, move);
        div(row + move, col + move, move);

    } //div

    public static boolean chkColor(int row, int col, int num){
        int color = arr[row][col];

        for(int i = row; i < row + num; i++){
            for(int j = col; j < col + num; j++){
                if(arr[i][j] != color){
                    return false;
                }
            }
        }
        return true;

    } // chkColor

}
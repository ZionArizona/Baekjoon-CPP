import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int N;
    static int zero = 0;
    static int one = 0;
    static int minus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row = 0;
        int col = 0;

        go(row, col, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);

    } // main

    public static void go(int row, int col, int Num){

        if(Num == 1){
            int chkNum = arr[row][col];
            if(chkNum == 0){
                zero++;
                return;
            }
            else if(chkNum == 1){
                one++;
                return;
            }
            else if(chkNum == -1){
                minus++;
                return;
            }
        }



        if(chk(row, col, Num)){ // 검사 했는다 참이다.
            int chkNum = arr[row][col];
            if(chkNum == 0){
                zero++;
            }
            else if(chkNum == 1){
                one++;
            }
            else if(chkNum == -1){
                minus++;
            }

        }else{
            int div = Num/3;
            go(row,col,div);
            go(row,col + div,div);
            go(row,col + div*2,div);
            go(row + div, col, div);
            go(row + div*2, col, div);
            go(row + div,col + div,div);
            go(row + div,col + div*2,div);
            go(row + div * 2,col + div,div);
            go(row + div * 2,col + div*2,div);

        }





    } //go

    public static boolean chk(int row, int col, int Num){
        int chkNum = arr[row][col];

        for(int i = row; i < row + Num; i++){
            for(int j = col; j < col + Num; j++){
                if(chkNum != arr[i][j]){
                    return false;
                }


            }
        }

        return true;

    } // chk


}
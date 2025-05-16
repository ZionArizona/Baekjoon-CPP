import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

         arr = new int[9][9];

        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(-1,0);

    } // main

    static void dfs(int row, int col){
        if(col % 9 == 0){
            row += 1;
            col = 0;
        }


        //기저 조건
        if(row == 8 && col == 8){

            if(arr[row][col] == 0){
                for(int i = 1; i <= 9; i++){
                    if(check(row,col, i)){
                        arr[row][col] = i;
                    }
                }
            }

            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(arr[row][col] == 0){
            //1~9 가능한 숫자 넣기
            for(int num = 1; num <= 9; num++){
                // num이 가능하다면
                if(check(row, col, num)){
                    // 백트랙킹
                    arr[row][col] = num;
                    dfs(row, col+1);
                    arr[row][col] = 0;
                }
            }
        }
        else{
            dfs(row, col+1);
        }

    }  //dfs

    static boolean check(int row, int col, int num){
        //가로 체크
        for(int i = 0; i < 9; i++){
            if(arr[row][i] == num) return false;
        }

        // 세로 체크
        for(int i = 0; i < 9; i++){
            if(arr[i][col] == num) return false;
        }

        // 네모 체크
        int stRow = (row/3)*3;
        int stCol = (col/3)*3;


        for(int i = stRow; i < stRow+3; i++){
            for(int j = stCol; j < stCol + 3; j++){
                if(arr[i][j] == num) return false;
            }
        }


        return true;
    }

}
import java.sql.Array;
import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N;
    static int[][] arr;
    static int cnt;
    static int[][][] dir = {

            {{1,1}, {0,1},{1,0}}, //대각선
            {{1,1},{0,1}},  //가로
            {{1,1},{1,0}} //세로

    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[]{0,1,1}); // 행  열  방향

        while(!que.isEmpty()){

            int[] point = que.poll();

            int row = point[0];
            int col = point[1];
            int dr = point[2];

            if(row == N-1 && col == N-1){
                cnt++;
                continue;
            }

            int[][] direction = dir[dr];

            for(int i = 0; i < direction.length; i++){

                int nextrow = row+ direction[i][0];
                int nextcol = col +direction[i][1];

                // 범위 검사
                if(direction[i][0] == 1 && direction[i][1] == 1 && checkDia(row, col)) { //대각선일 경우
                    que.offer(new int[] {nextrow, nextcol, 0});
                }
                if(direction[i][0] == 0 && direction[i][1] == 1 && checkWidth(nextrow, nextcol)){  // 가로
                    que.offer(new int[] {nextrow, nextcol, 1});
                }
                if(direction[i][0] == 1 && direction[i][1] == 0 && checkHeight(nextrow, nextcol)){ // 세로
                    que.offer(new int[] {nextrow, nextcol, 2});
                }

            }

        } // while

        System.out.println(cnt);

    } //main

    private static boolean checkHeight(int row, int col){


        if(row < 0 || row >= N || col < 0 || col >= N) return false;
        if(arr[row][col] == 1) return false;

        return true;

    }

    private static boolean checkWidth(int row, int col){


        if(row < 0 || row >= N || col < 0 || col >= N) return false;
        if(arr[row][col] == 1) return false;

        return true;
    }

    private static boolean checkDia(int row, int col){

        for(int i = 0; i < 3; i++){
            int nextrow = row + dir[0][i][0];
            int nextcol = col + dir[0][i][1];

            if(nextrow < 0 || nextrow >= N || nextcol < 0 || nextcol >= N) return false;
            if(arr[nextrow][nextcol] == 1) return false;

        }

        return true;
    } // Dia

}
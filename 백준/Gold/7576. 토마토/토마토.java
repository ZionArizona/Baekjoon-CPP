import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int[] drow = {0,0,-1,1}; // 좌  우  상  하
    static int[] dcol = {-1,1,0,0};
    static int N;
    static int M;
    static Queue<tomato> que;

    static class tomato{
        int x;
        int y;
        int day;

        tomato(int row, int col, int day) {
            this.x = row;
            this.y = col;
            this.day = day;
        }
    } // tomato


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        que = new LinkedList<>();
        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                //if(arr[i][j] == 0) tmpans++;
                if(arr[i][j] == 1){
                    que.offer(new tomato(i,j,0));
                }
            }

        }

        bfs();

    } // main

    static void bfs(){

        int day = 0;

        while(!que.isEmpty()){

            tomato chk = que.poll();

            day = chk.day;

            for(int i = 0; i < 4; i++){
                int nextrow = chk.x + drow[i];
                int nextcol = chk.y + dcol[i];

                if(nextrow >= 0 && nextrow < N && nextcol >= 0 && nextcol < M){
                    if(arr[nextrow][nextcol] == 0){
                        arr[nextrow][nextcol] = 1;
                        que.offer(new tomato(nextrow, nextcol, day+1));
                    }
                }
            }
        }

        if(chkRest()){
            System.out.println(day);
        }else{
            System.out.println(-1);
        }


    } //bfs

    static boolean chkRest(){

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0) return false;
            }
        }

        return true;

    } // chkRest

}
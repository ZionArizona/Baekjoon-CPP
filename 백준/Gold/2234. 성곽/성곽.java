import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] arr;
    static boolean[][] vis;
    static int[] drow = {0,-1,0,1}; //
    static int[] dcol = {-1,0,1,0};
    static int cntRoom;
    static int maxRoom;
    static int tmpRoom;
    static int maxRoom2;
    static int[] wall = {1,2,4,8};  // 좌   상   우    하
    static int[][] room;
    static int num;
    static int[] roomCnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        vis = new boolean[M][N];
        room = new int[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cntRoom = 0;
        maxRoom = 0;
        num = 0;
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!vis[i][j]) {
                    num++;
                    tmpRoom = 0;
                    cntRoom++;
                    dfs(i, j);
                    maxRoom = Math.max(maxRoom, tmpRoom);
                }
            }
        }

        roomCnt = new int[num+1];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                roomCnt[room[i][j]]++;
            }
        }

        maxRoom2 = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                merge(i,j);
            }
        }

//        for(int i = 0; i < M; i++){
//            for(int j = 0; j < N; j++){
//                System.out.print(room[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//
//        for(int i = 1; i <= num; i++){
//            System.out.print(roomCnt[i] + " ");
//        }

        System.out.println(cntRoom);
        System.out.println(maxRoom);
        System.out.println(maxRoom2);

    } // main


    static void merge(int row, int col){

        int tmp1 = room[row][col];

        for(int i = 0; i < 4; i++){
            int nextrow = row + drow[i];
            int nextcol = col + dcol[i];

            if(nextrow < 0 || nextrow >= M || nextcol < 0 || nextcol >= N) continue;

            int tmp2 = room[nextrow][nextcol];

            if(tmp1 == tmp2) continue;
            if(tmp1 != tmp2){
                maxRoom2 = Math.max(maxRoom2, roomCnt[tmp1] + roomCnt[tmp2]);
            }
        }
    }

    static void dfs(int row, int col){
        tmpRoom++;
        vis[row][col] = true;
        room[row][col] = num;

        for(int i = 0; i < 4; i++){

            if((arr[row][col] & wall[i]) == wall[i]) continue;

            int nextrow = row + drow[i];
            int nextcol = col + dcol[i];

            if(vis[nextrow][nextcol]) continue;

            dfs(nextrow, nextcol);
        }

    } //dfs

}
import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N,M;
    static int robotRow, robotCol;
    static int[][] arr;
    static int cnt = 1;
    static int[] drow = {-1,0,1,0};  // 북  동  남  서
    static int[] dcol = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int robotRow = Integer.parseInt(st.nextToken());
        int robotCol = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(robotRow, robotCol, direction);

        System.out.println(cnt);


    } //main


    static private void go(int row, int col, int dir) {
        arr[row][col] = -1;

        if(check(row, col)){ // 청소할 구역이 없는 경우. 즉 4방향 모두 -1 또는 1(벽)
            int d = (dir+2)%4;
            int chkRow = row + drow[d];
            int chkCol = col + dcol[d];
            if(chkRow >= 0 && chkRow < N && chkCol >= 0 && chkCol < M && arr[chkRow][chkCol] == -1){
                go(chkRow, chkCol, dir);
            }
            // 뒤로 후진 불가능 하면 끝
        }
        else{ // 청소할 구역이 있는 경우
            // 반시계 방향
            for(int i = 0; i < 4; i++){
                dir = (dir+3)%4;

                int r = row + drow[dir];
                int c = col + dcol[dir];
                if(r >= 0 && r < N && c >= 0 && c < M && arr[r][c] == 0){
                    cnt++;
                    go(r,c,dir);
                    return;
                }

            }
        }


    } //go

    static private boolean check(int row, int col){

        for(int i = 0; i < 4; i++){
            int nextrow = row + drow[i];
            int nextcol = col + dcol[i];

            if(arr[nextrow][nextcol] == 0) return false;

        }
        return true;
    } // check

}
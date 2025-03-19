import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N;
    static char[][] arr;
    static boolean[][][] vis;
    static int[] drow = {-1,1,0,0}; // 상  하  좌  우  90도
    static int[] dcol = {0,0,-1,1};
    static int ans;
    static int flag;
    static int[][] e;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] b = new int[3][2];
        e = new int[3][2];
        arr = new char[N][N];
        vis = new boolean[N][N][2];
        int num = 0;
        int nume = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                if(str.charAt(j) == 'B'){
                    b[num][0] = i;
                    b[num][1] = j;
                    num++;
                    arr[i][j] = '0';
                }
                else if(str.charAt(j) == 'E'){
                    e[nume][0] = i;
                    e[nume][1] = j;
                    nume++;
                    arr[i][j] = '0';
                }
                else{
                    arr[i][j] = str.charAt(j);
                }

            }
        }

        flag = 1;
        // 0는 가로 1 세로
        if(b[0][1] == b[1][1] && b[1][1] == b[2][1]){ //세로
            flag = 1;
        }
        else{ // 가로
            flag = 0;
        }

        ans = 0;

        go(b[1][0], b[1][1], flag);

        System.out.println(ans);

    } //main

    static void go(int row, int col, int flag){
        Queue<int[]> que = new ArrayDeque<>();
        // que에는 row, col , depth, flag 정보가 들어가야 한다.
        que.offer(new int[]{row,col,0,flag});
        vis[row][col][flag] = true;

        while(!que.isEmpty()){

            int[] chk = que.poll();

            if(chk[3] == 0){ //가로일 때
                int midr = chk[0];
                int midc = chk[1];
                int midlr = chk[0];
                int midlc = chk[1] -1;
                int midrr = chk[0];
                int midrc = chk[1] + 1;

                if((e[0][0] == midlr && e[0][1] == midlc) && (e[1][0] == midr && e[1][1] == midc) && (e[2][0] == midrr && e[2][1] == midrc)){
                    ans = chk[2];
                    break;
                }

            }else{ //세로일 때
                int midr = chk[0];
                int midc = chk[1];
                int midur = chk[0] - 1;
                int miduc = chk[1];
                int middr = chk[0] + 1;
                int middc = chk[1];

                if((e[0][0] == midur && e[0][1] == miduc) && (e[1][0] == midr && e[1][1] == midc) && (e[2][0] == middr && e[2][1] == middc)){
                    ans = chk[2];
                    break;
                }

            }


            for(int i = 0; i < 5; i++){


                if(i == 4){ // 이때 가로 세로 크기가 바뀐다.
                    if(chk[3] == 0){ //가로
                        int newD = 1;
                        if(canrotate(chk[0],chk[1],newD) && !vis[chk[0]][chk[1]][newD]){
                            vis[chk[0]][chk[1]][newD] = true;
                            que.offer(new int[] {chk[0],chk[1],chk[2]+1,newD});

                        }

                    }
                    else{  //세로
                        int newD = 0;
                        if(canrotate(chk[0],chk[1],newD) && !vis[chk[0]][chk[1]][newD]){
                            vis[chk[0]][chk[1]][newD] = true;
                            que.offer(new int[] {chk[0],chk[1],chk[2]+1,newD});
                        }
                    }
                }
                else{
                    if(chk[3] == 0){ //가로
                        int nextmidr = chk[0] + drow[i];
                        int nextmidc = chk[1] + dcol[i];
                        int nextlr = chk[0] + drow[i];
                        int nextlc = chk[1] - 1 + dcol[i];
                        int nextrr = chk[0] + drow[i];
                        int nextrc = chk[1] + 1 + dcol[i];

                        //범위 안 검사.
                        if(isin(nextmidr,nextmidc) && isin(nextlr, nextlc) && isin(nextrr, nextrc) && !vis[nextmidr][nextmidc][chk[3]]){
                            vis[nextmidr][nextmidc][chk[3]] = true;
                            que.offer(new int[]{nextmidr, nextmidc, chk[2]+1, chk[3]});
                        }
                    }
                    else{ //세로 일때
                        int nextmidr = chk[0] + drow[i];
                        int nextmidc = chk[1] + dcol[i];
                        int nextur = chk[0] - 1 + drow[i];
                        int nextuc = chk[1] + dcol[i];
                        int nextdr = chk[0] + 1 + drow[i];
                        int nextdc = chk[1] + dcol[i];

                        if(isin(nextmidr, nextmidc) && isin(nextur, nextuc) && isin(nextdr, nextdc) && !vis[nextmidr][nextmidc][chk[3]]){
                            vis[nextmidr][nextmidc][chk[3]] = true;
                            que.offer(new int[]{nextmidr, nextmidc, chk[2] + 1, chk[3]});
                        }

                    }
                }

            } // 방향 for

        } // bfs while

    } //go

    static boolean canrotate(int row, int col,int newD){
        //가운데를 기준으로 8방향이 1이 없는지를 확인
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int nextrow = row + i;
                int nextcol = col + j;
                if(!isin(nextrow,nextcol)){
                    return false;
                }
            }
        }
        return true;
    }


    static boolean isin(int row, int col){

        if(row >= 0 && row < N && col >= 0 && col < N && arr[row][col] != '1'){
            return true;
        }
        return false;
    }

}
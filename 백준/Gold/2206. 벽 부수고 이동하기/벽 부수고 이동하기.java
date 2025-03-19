import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N,M;
    static char[][] arr;
    static boolean[][][] vis;
    static int[] drow = {-1,1,0,0}; //상   하   좌   우
    static int[] dcol = {0,0,-1,1};
    static int ans;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        vis = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < M; j++) {
//                System.out.print(arr[i][j] + " ");
//
//            }
//            System.out.println();
//        }


        flag = false;
        ans = 0;
        bfs(0,0,1);

        if(flag == false){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }


    } //main


    static void bfs(int row, int col, int depth) {

        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[] {row,col,depth,0});
        vis[row][col][0] = true;

        while(!que.isEmpty()) {

            int[] chk = que.poll();

            if(chk[0] == N-1 && chk[1] == M-1){
                flag = true;
                ans = chk[2];
                break;
            }

            for(int i = 0; i < 4; i++) {

                int nextrow = chk[0] + drow[i];
                int nextcol = chk[1] + dcol[i];

                if(nextrow < 0 || nextrow == N || nextcol < 0 || nextcol == M) continue;

                if(arr[nextrow][nextcol] == '1'){
                    if(chk[3] == 0 && !vis[nextrow][nextcol][1]){
                        vis[nextrow][nextcol][1] = true;
                        que.offer(new int[] {nextrow,nextcol, chk[2]+1, chk[3] + 1});
                        //System.out.println(nextrow + " " + nextcol + " " + (depth+1) );
                    }
                }else{
                    if(!vis[nextrow][nextcol][chk[3]]){
                        vis[nextrow][nextcol][chk[3]] = true;
                        que.offer(new int[] {nextrow, nextcol, chk[2]+1, chk[3]});
                        //System.out.println(nextrow + " " + nextcol + " " + (depth+1));
                    }
                }

            }

        }

    } // bfs
}
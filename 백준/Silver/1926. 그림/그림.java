import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N,M;
    static boolean[][] vis;
    static int[][] arr;
    static int[] drow = {-1,1,0,0};  // 상   하   좌   우
    static int[] dcol = {0,0,-1,1};
    static int ans;
    static int cnt;
    static int chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        vis = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0;j < M; j++){
                if(arr[i][j] == 1 && !vis[i][j]){
                    chk = 0;
                    ans++;
                    dfs(i,j,1);
                    cnt = Math.max(cnt, chk);
                }
            }
        }

        System.out.println(ans);
        System.out.println(cnt);

    } //main

    static void dfs(int row, int col, int depth){
        vis[row][col] = true;
        chk++;
        cnt = Math.max(cnt, depth);

        for(int i = 0; i < 4; i++){

            int nextrow = row + drow[i];
            int nextcol = col + dcol[i];

            if(nextrow >= 0 && nextrow < N && nextcol >= 0 && nextcol < M && arr[nextrow][nextcol] == 1 && !vis[nextrow][nextcol]){

                dfs(nextrow, nextcol, depth+1);

            }
        }
    } //dfs
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m;
    static boolean[][] vis;
    static int[][] arr;
    static int[] dr = new int[] {1,0};  // 상  좌   하   우
    static int[] dc = new int[] {0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0,0);

        System.out.println("No");

    } // main

    static void dfs(int r, int c){
        vis[r][c] = true;

        if((r == m -1) && (c == n-1)){
            System.out.println("Yes");
            System.exit(0);
        }

        for(int i = 0; i < 2; i++){

            int nextrow = r + dr[i];
            int nextcol = c + dc[i];

            if((nextrow >= 0 && nextrow < m && nextcol >= 0 && nextcol < n) && !vis[nextrow][nextcol] && arr[nextrow][nextcol] == 1){
                dfs(nextrow, nextcol);
            }
        }
    }
}
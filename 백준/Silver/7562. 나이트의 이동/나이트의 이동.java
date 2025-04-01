import java.sql.Array;
import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[][] vis;
    static int[] drow = {-2,-1,1,2,2,1,-1,-2};
    static int[] dcol = {-1,-2,-2,-1,1,2,2,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int t = 0; t < N; t++){
            int I = Integer.parseInt(br.readLine());
            arr = new int[I][I];
            vis = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            int startrow = Integer.parseInt(st.nextToken());
            int startcol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int finalrow = Integer.parseInt(st.nextToken());
            int finalcol = Integer.parseInt(st.nextToken());

            Queue<int[]> que = new ArrayDeque<>();

            que.offer(new int[] {startrow, startcol, 0});  // 행 열 depth

            int ans = 0;

            while(!que.isEmpty()){

                int[] p = que.poll();
                vis[p[0]][p[1]] = true;

                if(p[0] == finalrow && p[1] == finalcol){
                    ans = p[2];
                    break;
                }

                for(int i = 0; i < 8; i++){

                    int nextrow = p[0] + drow[i];
                    int nextcol = p[1] + dcol[i];

                    if(nextrow < 0 || nextrow >= I || nextcol < 0 || nextcol >= I) continue;

                    if(!vis[nextrow][nextcol]){
                        vis[nextrow][nextcol] = true;
                        que.offer(new int[] {nextrow,nextcol,p[2] +1});
                    }


                }
            }

            System.out.println(ans);
        }

    } //main

}
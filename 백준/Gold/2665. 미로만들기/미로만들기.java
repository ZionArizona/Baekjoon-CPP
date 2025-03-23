import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N;
    static int[][] arr;
    static int[][] cnt;
    static Queue<int[]> que = new LinkedList<>();
    static int[] drow = {-1,1,0,0};  // 상 하 좌 우
    static int[] dcol = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        cnt = new int[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = str.charAt(j) - '0';
                cnt[i][j] = Integer.MAX_VALUE;
            }
        }


        cnt[0][0] = 0;
        que.offer(new int[] {0,0});

        bfs();

        System.out.println(cnt[N-1][N-1]);


    } //main


    static private void bfs(){

        while(!que.isEmpty()){
            int[] p = que.poll();


            for(int i = 0; i < 4; i++){

                int nextrow = p[0] + drow[i];
                int nextcol = p[1] + dcol[i];

                if(isin(nextrow,nextcol)){

                    if(arr[nextrow][nextcol] == 1 && (cnt[nextrow][nextcol] > cnt[p[0]][p[1]])){
                        cnt[nextrow][nextcol] = cnt[p[0]][p[1]];
                        que.offer(new int[]{nextrow, nextcol});
                    }
                    if(arr[nextrow][nextcol] == 0 && (cnt[nextrow][nextcol] > cnt[p[0]][p[1]] + 1)){
                        cnt[nextrow][nextcol] = cnt[p[0]][p[1]] + 1;
                        que.offer(new int[]{nextrow, nextcol});
                    }


                }

            }

        }

    } // bfs

    static private boolean isin(int row, int col){

        if(row >= 0  && row < N && col >= 0 && col < N){
            return true;
        }
        return false;
    } // isin
}
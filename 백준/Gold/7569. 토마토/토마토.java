import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N;
    static int M;
    static int H;
    static int[][][] arr;
    static boolean[][][] vis;
    static int zero;
    static Queue<int[]> que = new ArrayDeque<>();
    static int[] drow = {-1,1,0,0,0,0};  // 상 하 좌 우 위 아래
    static int[] dcol = {0,0,-1,1,0,0};
    static int[] dhe = {0,0,0,0,1,-1};
    static int ans;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        vis = new boolean[H][N][M];

        zero = 0;
        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    arr[h][i][j] = Integer.parseInt(st.nextToken());
                    if(arr[h][i][j] == 0) zero++;
                    if(arr[h][i][j] == 1){
                        que.offer(new int[]{h,i,j,0});
                    }
                }
            }
        }
        
        flag = false;
        ans = 0;

        if(zero == 0){
            System.out.println(0);
        }
        else{

            if(bfs()){
                System.out.println(ans);
            }
            else{
                System.out.println(-1);
            }
        }


    } //main


    static private boolean bfs(){

        int cnt = 0;
        while(!que.isEmpty()){
            cnt++;
            int size = que.size();
            while (size-- > 0) {
                int[] p = que.poll();
                vis[p[0]][p[1]][p[2]] = true;

                for(int i = 0; i < 6; i++){

                    int r = p[1] + drow[i];
                    int c = p[2] + dcol[i];
                    int h = p[0] + dhe[i];
                    if(isin(r,c,h)){
                        if(arr[h][r][c] == 0){

                            zero--;
                            arr[h][r][c] = 1;
                            vis[h][r][c] = true;

                            que.offer(new int[] {h,r,c,cnt+1});

                        }
                    }
                }
                if(zero == 0){
                    ans = cnt;
                    return true;
                }

            }


        }
        return false;

    } // bfs

    static private boolean isin(int row, int col, int height){

        if(row >= 0  && row < N && col >= 0 && col < M && height >= 0 && height < H && !vis[height][row][col]){
            return true;
        }
        return false;
    } // isin
}
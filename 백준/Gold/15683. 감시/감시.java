import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N,M;
    static List<Point> list;
    static int[][] arr;
    static int[][] tmp;
    static int[][][][] dir = {

            {}, //0번
            {  {{-1,0}} , {{1,0}} , {{0,-1}} , {{0,1}}   }, //1번
            {   { {-1,0}, {1,0} } ,    { {0,-1} , {0,1} }   }, //2번
            {  {{1,0},{0,-1}} , {{-1,0},{0,-1}},   {{-1,0},{0,1}},   {{1,0},{0,1}} }, //3번
            {  { {1,0},{0,-1},{-1,0} } , { {0,-1},{-1,0}, {0,1}} , { {-1,0}, {0,1}, {1,0}} , {{0,1}, {1,0}, {0,-1}} }, //4번
            {  { {1,0},{0,-1},{-1,0},{0,1}   }    } //5번

    };
    static int ans;


    private static class Point{

        int x;
        int y;
        int num;

        Point(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        list = new ArrayList<>();


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) list.add(new Point(i, j, 1));
                else if (arr[i][j] == 2) list.add(new Point(i, j, 2));
                else if (arr[i][j] == 3) list.add(new Point(i, j, 3));
                else if (arr[i][j] == 4) list.add(new Point(i, j, 4));
                else if (arr[i][j] == 5) list.add(new Point(i, j, 5));
            }
        }

        ans = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(ans);
    } //main


    static private void dfs(int cnt) {

        if(cnt == list.size()) {
            //map zero 카운트
            int zero = cal();
            ans = Math.min(ans, zero);
            //for(int i = 0; i < N; i++){
              //  for(int j = 0; j < M; j++){
                   // System.out.print(arr[i][j] + " ");
             //   }
              //  System.out.println();
         //   }


         //   System.out.println();
            return;
        }

        Point p = list.get(cnt);

        int x = p.x;
        int y = p.y;
        int num = p.num;

        int[][][] di = dir[num];

        int size = di.length;

        for(int i = 0; i < size; i++) {


            // 배열 1로 변환
            // 2차원 배열 뽑아
            int[][] A = di[i];
            int s = A.length;
            for(int c = 0; c < s; c++) {

                //change
                change(p.x, p.y, A[c],true);

            }
            // dfs
            dfs(cnt+1);


            // 배열 0으로 다시 변환
            for(int c = 0; c < s; c++){

                change(p.x, p.y, A[c], false);
            }

        }

    } //dfs

    static void change(int row, int col, int[] direction,boolean flag){

            int s = 1;
            while(true){
                int r = row + direction[0]*s;
                int c = col + direction[1]*s;

                if(r < 0 || c < 0 || r >= N || c >= M || arr[r][c] == 6) break;


               if(arr[r][c] <= 0 && flag == true) arr[r][c] += -1;
               if(arr[r][c] <= 0 && flag == false) arr[r][c] += 1;

                s++;

            }

    } //change

    static int cal(){
        int z = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0) z++;
            }
        }
        return z;
    }


}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] range = new int[M][4];

        int[][] arr = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];


        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j-1] + sum[i-1][j] + arr[i][j] - sum[i-1][j-1];
            }
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            range[i][0] = Integer.parseInt(st.nextToken());
            range[i][1] = Integer.parseInt(st.nextToken());
            range[i][2] = Integer.parseInt(st.nextToken());
            range[i][3] = Integer.parseInt(st.nextToken());
        }


//        for(int i = 1; i <= N; i++){
//            for(int j = 1; j <= N; j++){
//                System.out.print(sum[i][j] + " ");
//            }
//
//            System.out.println();
//
//        }

        for(int i = 0; i < M; i++){
            int x1 = range[i][0];
            int y1 = range[i][1];
            int x2 = range[i][2] ;
            int y2 = range[i][3];

//            System.out.println(sum[x2][y2]);
//            System.out.println(sum[x1 - 1][y2]);
//            System.out.println(sum[x2][y1-1]);
//            System.out.println(sum[x1 - 1][y1 - 1]);

            sb.append((sum[x2][y2] -sum[x1 - 1][y2] -sum[x2][y1-1] + sum[x1 - 1][y1 - 1]) + "\n" );

        }
        System.out.println(sb);
    }
}

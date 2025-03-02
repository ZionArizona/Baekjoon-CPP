import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int deep = Math.min(N,M)/2;

        for(int layer = 0; layer < deep; layer++){

            int top = layer;
            int left = layer;
            int right = M - 1 - layer;
            int bottom = N - 1 - layer;

            // 굳이 R만큼 모두 다 회전할 필요없다. 회전은 R%둘레 만큼만 해주면 된다.
            int rotate = R % (2 * ((right - left) + (bottom - top)));

            for(int r = 0; r < rotate; r++){
                int temp = arr[top][left];  // 왼쪽 상단 값 저장

                //반시계 방향
                // 1. 위쪽 행: 왼쪽으로 이동 (즉, 각 요소가 오른쪽 요소로 대체)
                for (int j = left; j < right; j++) {
                    arr[top][j] = arr[top][j+1];
                }

                // 2. 오른쪽 열: 위로 이동 (즉, 각 요소가 아래쪽 요소로 대체)
                for (int i = top; i < bottom; i++) {
                    arr[i][right] = arr[i+1][right];
                }

                // 3. 아래쪽 행: 오른쪽으로 이동 (즉, 각 요소가 왼쪽 요소로 대체)
                for (int j = right; j > left; j--) {
                    arr[bottom][j] = arr[bottom][j-1];
                }

                // 4. 왼쪽 열: 아래로 이동 (즉, 각 요소가 위쪽 요소로 대체)
                for (int i = bottom; i > top; i--) {
                    arr[i][left] = arr[i-1][left];
                }

                // 5. 저장해두었던 값 대입 (원래 왼쪽 상단 위치 바로 아래)
                arr[top+1][left] = temp;
            }

        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    } //main

}
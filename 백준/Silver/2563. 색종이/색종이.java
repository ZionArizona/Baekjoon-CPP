import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] st = new int[101][101];
        int ans = 0;

        for(int k = 0; k < N; k++){
            String[] str = br.readLine().split(" ");
            int row = Integer.parseInt(str[0]);
            int col = Integer.parseInt(str[1]);

            for(int i = row; i < row + 10; i++){
                for(int j = col; j < col + 10; j++){
                    st[i][j] = 1;
                }
            }
        }

        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                if(st[i][j] == 1){
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static String[][] arr;
    static List<int[]> teacher;
    static int num;
    static int[] drow = {1,0,-1,0};
    static int[] dcol = {0,1,0,-1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        teacher = new ArrayList<>();

        StringTokenizer st;

        for(int i= 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = st.nextToken();
                if(arr[i][j].equals("T")){
                    teacher.add(new int[]{i,j});
                }
            }

        }


        num = 0;
        dfs(0);

        System.out.println("NO");


    } // main

    static void dfs(int cnt){

        if(cnt == 3){

            if(check()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }


        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j].equals("S") || arr[i][j].equals("T") || arr[i][j].equals("O")) continue;
                arr[i][j] = "O";
                dfs(cnt+1);
                arr[i][j] = "X";
            }
        }

    } //dfs

    static boolean check(){

        for(int[] chk : teacher){

            int row = chk[0];
            int col = chk[1];


            for(int i = 0; i < 4; i++){
                int c = 1;

                while(true){
                    int nextrow = row + drow[i]*c;
                    int nextcol = col + dcol[i]*c;

                    if( (nextrow < 0 || nextrow >= N || nextcol < 0 || nextcol >= N) || arr[nextrow][nextcol].equals("O")){
                        break;
                    }

                    if(arr[nextrow][nextcol].equals("S")){
                        return false;
                    }

                    c++;
                }
            }
        }
        return true;
    }
}
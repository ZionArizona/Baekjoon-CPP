import java.util.*;
import java.io.*;

public class Solution {

    static int N,ans;
    static int[][] arr;
    static Set<Integer> set;
    static int[][] direction = {{1,1},{1,-1},{-1,-1},{-1,1}};

    static class Point{

        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            ans = -1;
            set = new HashSet<>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    DFS(new Point(i,j),new Point(i,j), 0);
                }
            }
            sb.append("#" + test + " " + ans + "\n");
        }

        System.out.println(sb);

    } //main

    static void DFS(Point start, Point point, int dir){

        if(dir == 3 && point.x == start.x && point.y == start.y){
            if(ans < set.size()){
                ans = set.size();
            }
            return;
        }

        for(int i = dir; i <= Math.min(dir+1, 3); i++){
            int x = point.x + direction[i][0];
            int y = point.y + direction[i][1];

            if(x >= 0 && x < N && y >= 0 && y < N && !set.contains(arr[x][y])){
                set.add(arr[x][y]);
                DFS(start, new Point(x,y), i);
                set.remove(arr[x][y]);
            }
        }
    } //DFS
}

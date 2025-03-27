import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static List<List<Integer>> list;
    static boolean flag;
    static int[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        for(int n = 0; n < N ; n++){
            
            st = new StringTokenizer(br.readLine());
    
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
    
            list = new ArrayList<>();
    
            for(int i = 0; i <= E; i++){
                list.add(new ArrayList<>());
            }
    
            for(int i = 0; i < V; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
    
                list.get(from).add(to);
                list.get(to).add(from);
    
            }
            vis = new int[E+1];
    
            flag = true; // 이분 그래프이다.
            // 빨강 -1, 파랑 1
            for(int i = 1; i <= E; i++){
                if(vis[i] == 0){
                    go(i,1);
                }
    
                if(flag == false) break;
            }
    
            if (flag == false) {
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
        


    } //main

    static void go(int start, int color){

        vis[start] = color;

        for(Integer next : list.get(start)){

            if(vis[next] == 0){ //탐색 필요
                go(next, -color);
            }
            else if(vis[next] == color){
                flag = false;
                return;
            }

        }


    } // go


}
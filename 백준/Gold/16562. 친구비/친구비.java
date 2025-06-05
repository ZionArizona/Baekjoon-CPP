import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m,k;
    static int[] cost;
    static boolean[] vis;
    static List<List<Integer>> list;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        vis = new boolean[n+1];
        cost = new int[n+1];
        list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        int total_cost = 0;

        for(int i = 1; i <= n; i++){
            if(!vis[i]){
                int mincost = dfs(i);
                total_cost += mincost;
            }
        }

        if(total_cost <= k){
            System.out.println(total_cost);
        }
        else{
            System.out.println("Oh no");
        }

    } // main

    static private int dfs(int node){
        vis[node] = true;

        int min_cost = cost[node];

        for(Integer chk : list.get(node)){
            if(!vis[chk]){
                min_cost = Math.min(min_cost, dfs(chk));
            }
        }



        return min_cost;
    }

}
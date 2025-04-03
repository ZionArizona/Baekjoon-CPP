import java.sql.Array;
import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {


    private static class Edge{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static int N,Q;
    static long K;
    static List<List<Edge>> list;
    static boolean[] vis;
    static int ans;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(from).add(new Edge(to, weight));
            list.get(to).add(new Edge(from, weight));
        }

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            vis = new boolean[N+1];
            ans = Integer.MAX_VALUE;
            cnt = 0;
            dfs(V);

            sb.append(cnt).append("\n");

        }

        System.out.println(sb);

    } //main

    static private void dfs(int Ver){

        vis[Ver] = true;


        for(Edge e : list.get(Ver)){

            if(!vis[e.to]){
                int chk = Math.min(ans, e.weight);
                if(chk >= K){
                    cnt++;
                    ans = Math.min(ans, e.weight);
                    dfs(e.to);
                }
            }

        }

    } //dfs

}
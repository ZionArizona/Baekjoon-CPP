import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N,M;
    static boolean[] vis;
    static List<List<Integer>> list = new ArrayList<>();
    static int ans;
    static int Ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        Ans = Integer.MAX_VALUE;
        int idx = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            ans = 0;
            vis = new boolean[N+1];
            bfs(i);
            if(ans < Ans){
                Ans = ans;
                idx = i;
            }
            else if(ans == Ans){
                Ans = ans;
                if(i < idx){
                    idx = i;
                }
            }
        }

        System.out.println(idx);

    } //main

    static void bfs(int node){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {node,0});
        vis[node] = true;

        while(!que.isEmpty()){

            int[] p = que.poll();

            for(Integer c : list.get(p[0])){

                if(!vis[c]){
                    ans += (p[1] + 1);
                    vis[c] = true;
                    que.offer(new int[] {c,p[1]+1});
                }
            }
        }
    }
}
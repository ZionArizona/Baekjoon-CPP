import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N,M,K,X;
    static boolean[] vis;
    static List<List<Integer>> list = new ArrayList<>();
    static int ans;
    static int cnt;
    static int chk;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        vis = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i= 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            list.get(node1).add(node2);

        }

        bfs(X);

        Collections.sort(answer);
        if(answer.size() == 0){
            System.out.println(-1);
        }
        else{
            for(Integer p : answer){
                System.out.println(p);
            }
        }
        
    } //main

    static void bfs(int node){
        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[]{node,0});
        vis[node] = true;

        while(!que.isEmpty()){

            int n[] = que.poll();

            if(n[1] == K){
                answer.add(n[0]);
            }

            for(Integer c : list.get(n[0])){

                if(!vis[c]){
                    vis[c] = true;
                    que.offer(new int[]{c,n[1]+1});
                }
            }
        }
    } //bfs
}
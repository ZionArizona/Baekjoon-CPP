import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N;
    static boolean[] vis;
    static int[] parent;
    static int f2;
    static Queue<Integer> que = new ArrayDeque<>();
    static List<List<Integer>> tree = new ArrayList<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int f1 = Integer.parseInt(st.nextToken());
        f2 = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        vis = new boolean[N+1];

        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=  0; i < M; i++){

            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);

        }

        ans = 0;

        dfs(f1,0);

        System.out.println(ans != 0 ? ans : -1);

    } //main


    static void dfs(int node, int depth){
        vis[node] = true;

        if(node == f2){
            ans = depth;
            return;
        }

        for(Integer n : tree.get(node)){
            if(!vis[n]){
                vis[n] = true;
                dfs(n, depth+1);
            }
        }
    }//dfs
}
import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N;
    static boolean[] vis;
    static int[] parent;
    static Queue<Integer> que = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        List<List<Integer>> tree = new ArrayList<>();
        parent = new int[N + 1];
        vis = new boolean[N+1];

        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }

        for(int i=  0; i < N-1; i++){

            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);

        }

        que.add(1);
        vis[1] = true;

        while(!que.isEmpty()){

            int node = que.poll();

            for(Integer n : tree.get(node)){

                if(!vis[n]){
                    parent[n] = node;
                    vis[n] = true;
                    que.offer(n);
                }
            }
        }

        for(int i = 2; i <= N; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    } //main
}
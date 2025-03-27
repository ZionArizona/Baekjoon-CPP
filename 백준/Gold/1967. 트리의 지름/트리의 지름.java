import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static boolean visited[];
    static int N;

    static int solution = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());



        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1 ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end,cost));
            list.get(end).add(new Node(start,cost));
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            dfs(i,0);
        }

        System.out.println(solution);
    }
    static void dfs(int index, int cost){
        visited[index] = true;

        for(Node node : list.get(index)){
            if(!visited[node.edge]){
                dfs(node.edge,cost + node.cost);
            }
        }

        solution = Math.max(solution,cost);
    }



    static class Node{
        int edge;
        int cost;

        public Node(int edge,int cost){
            this.edge = edge;
            this.cost = cost;
        }
    }
}
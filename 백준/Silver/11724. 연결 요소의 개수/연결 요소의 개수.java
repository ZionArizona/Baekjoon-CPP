import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> list;
    static int ans;
    static boolean[] visited;
    static int v;
    static int e;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList<List<Integer>>();
        visited = new boolean[v+1];

        for(int i = 0; i < v+1; i++){
            list.add(new ArrayList<>());
        }


        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            list.get(c1).add(c2);
            list.get(c2).add(c1);

        }

        ans = 0;

        for(int i = 1; i <= v; i++){

            if(!visited[i]){
                ans++;
                bfs(i);
            }
        }

        System.out.println(ans);

    } // main

    static void bfs(int start){

        Queue<Integer> que = new LinkedList<>();

        que.offer(start);

        visited[start] = true;

        while(!que.isEmpty()){

           int current = que.poll();

           for(int i = 0; i < list.get(current).size(); i++){

               int temp = list.get(current).get(i);
               if(!visited[temp]){
                   visited[temp] = true;
                   que.offer(temp);
               }
           }
        }

    } //bfs
}
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int K;
    static Queue<Integer> que;
    static int ans;
    static int[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        if(N == K){
            System.out.println(0);
        }
        else{
            bfs(N);
        }

    } // main

    static void bfs(int num){

        que = new LinkedList<>();

        que.offer(num);
        visited[num] = 1;

        while(!que.isEmpty()){

            int cur = que.poll();
            for(int i = 0; i < 3; i++){
                int nextnum;

                if(i == 0){
                    nextnum = cur - 1;
                }
                else if(i == 1){
                    nextnum = cur + 1;
                }
                else{
                    nextnum = 2 * cur;
                }

                if(nextnum == K){
                    System.out.println(visited[cur]);
                    return;
                }

                if(nextnum >= 0 && nextnum <= 100000 && visited[nextnum] == 0){
                    visited[nextnum] = visited[cur] + 1;
                    que.offer(nextnum);
                }

            }

        }

    } //bfs

}
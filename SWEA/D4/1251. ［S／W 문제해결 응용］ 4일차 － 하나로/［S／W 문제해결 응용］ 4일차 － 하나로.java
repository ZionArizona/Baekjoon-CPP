import java.util.*;
import java.io.*;

public class Solution {


    private static class Node implements Comparable<Node> {

        int idx;
        long weight;

        public Node(int idx, long weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    static int N;
    static int[] x,y;
    static long[] minEdge;
    static boolean[] vis;

    private static long getDist(int a, int b){
        long dx = x[a] - x[b];
        long dy = y[a] - y[b];
        return dx * dx + dy * dy;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());

            x = new int[N];
            y = new int[N];
            minEdge = new long[N];
            vis = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                x[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                y[i] = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            Arrays.fill(minEdge, Long.MAX_VALUE);
            PriorityQueue<Node> que = new PriorityQueue<>();

            minEdge[0] = 0;
            que.offer(new Node(0,0));
            long total = 0;
            int count = 0;

            while(!que.isEmpty()){
                Node cur = que.poll();

                if(vis[cur.idx]) continue;

                vis[cur.idx] = true;
                total += cur.weight;
                count++;

                if(count == N) break;

                for(int i = 0; i < N; i++){
                    if(!vis[i]){
                        long dist = getDist(cur.idx, i);

                        if(dist < minEdge[i]){
                            minEdge[i] = dist;
                            que.offer(new Node(i, dist));
                        }

                    }
                }

            }
            long result = Math.round(total*E);
            sb.append("#").append(test).append(" ").append(result).append("\n");

        }

        System.out.println(sb);

    } // main

}
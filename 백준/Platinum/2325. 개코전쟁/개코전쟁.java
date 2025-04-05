import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int N, M;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 수
        M = Integer.parseInt(st.nextToken()); // 간선 수

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        // 원래 최단 경로 및 경로 추적
        int[] dist = new int[N + 1];
        int[] prev = new int[N + 1];
        dijkstra(1, dist, prev, -1, -1);

        int original = dist[N];

        // 최단 경로 추적하여 간선 목록 만들기
        List<int[]> shortestPathEdges = new ArrayList<>();
        int cur = N;
        while (prev[cur] != 0) {
            shortestPathEdges.add(new int[]{cur, prev[cur]});
            cur = prev[cur];
        }

        int maxDist = original;

        for (int[] e : shortestPathEdges) {
            int u = e[0], v = e[1];

            int[] tempDist = new int[N + 1];
            dijkstra(1, tempDist, new int[N + 1], u, v); // u-v 간선 제거

            if (tempDist[N] != Integer.MAX_VALUE) {
                maxDist = Math.max(maxDist, tempDist[N]);
            }
        }

        System.out.println(maxDist);
    }

    static void dijkstra(int start, int[] dist, int[] prev, int blockU, int blockV) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int now = cur.to;
            
            if(now == N) break;
            
            for (Edge next : graph.get(now)) {
                int to = next.to, w = next.weight;

                // 간선 제거 조건
                if ((now == blockU && to == blockV) || (now == blockV && to == blockU)) continue;

                if (dist[to] > dist[now] + w) {
                    dist[to] = dist[now] + w;
                    prev[to] = now;
                    pq.add(new Edge(to, dist[to]));
                }
            }
        }
    }
}
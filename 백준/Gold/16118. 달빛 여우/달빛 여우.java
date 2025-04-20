import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V,E;
    static List<List<int[]>> matrix = new ArrayList<>();
    static double fox[];
    static double wolf[][];
    static boolean visit[];
    static boolean visitW[][];

    static class node implements Comparable<node> {

        int idx;
        double cost;
        int state;


        public node(int idx, double cost, int state) {
            super();
            this.idx = idx;
            this.cost = cost;
            this.state = state;
        }


        public node(int idx, double cost) {
            super();
            this.idx = idx;
            this.cost = cost;
        }


        @Override
        public int compareTo(node o) {
            // TODO Auto-generated method stub
            return Double.compare(this.cost, o.cost);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        fox = new double[V];
        wolf = new double[V][2];
        visit = new boolean[V];
        visitW = new boolean[V][2];
        for(int i=0; i< V; i++) {
            matrix.add(new ArrayList<>());
        }

        for(int i=0; i< E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            matrix.get(from).add(new int[] {to,cost});
            matrix.get(to).add(new int[] {from,cost});

        }

        //System.out.println(Arrays.toString(fox));
        getFoxDistance();
        //System.out.println(Arrays.toString(fox));
        getWolfDistance();

//        for(int i = 0; i < wolf.length; i++){
//            for(int j = 0; j < wolf[i].length; j++){
//                System.out.print(wolf[i][j] + " ");
//            }
//            System.out.println();
//        }


        int count = 0;
        for(int i=0; i<V; i++) {
            double fd = fox[i];
            double wd = Math.min(wolf[i][0], wolf[i][1]);

            if(fd < wd) count++;
        }
        System.out.println(count);
    }

    static void getFoxDistance() {
        Arrays.fill(visit, false);

        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(0,0));

        Arrays.fill(fox, Double.MAX_VALUE);
        fox[0] = 0;
        while(!pq.isEmpty()) {
            node info = pq.poll();
            if(visit[info.idx]) continue;
            visit[info.idx] = true;

            for(int i=0; i< matrix.get(info.idx).size(); i++) {
                int arr[] = matrix.get(info.idx).get(i);
                int to = arr[0];
                double cost = arr[1];

                if(fox[to] > info.cost + cost) {
                    fox[to] = info.cost + cost;
                    pq.offer(new node(to,info.cost + cost));
                }

            }

        }
    }


    static void getWolfDistance() {
        Arrays.fill(visit, false);

        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(0,0,0));

        for(int i=0; i< V; i++) {
            Arrays.fill(wolf[i], Double.MAX_VALUE);
        }

        wolf[0][0] = 0;

        while(!pq.isEmpty()) {
            node info = pq.poll();
            if(visitW[info.idx][info.state]) continue;
            visitW[info.idx][info.state] = true;

            for(int i=0; i< matrix.get(info.idx).size(); i++) {
                int arr[] = matrix.get(info.idx).get(i);
                int to = arr[0];
                double cost = 0;

                cost = (info.state == 0 ? arr[1]/2.0 : arr[1]*2);
                double newDist  = info.cost + cost;

                int nextState = (info.state == 0 ? 1 : 0);

                if (wolf[to][nextState] > newDist) {
                    wolf[to][nextState] = newDist;
                    pq.offer(new node(to, newDist, nextState));
                }
            }

        }
    }

}


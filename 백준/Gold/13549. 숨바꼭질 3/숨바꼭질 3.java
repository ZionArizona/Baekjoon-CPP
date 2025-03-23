import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N,K;
    static boolean[] vis;
    static Queue<point> que = new ArrayDeque<>();
    static int ans;

    static private class point{
        int p;
        int sec;
        point(int p,int sec){
            this.p = p;
            this.sec = sec;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        vis = new boolean[100001];

        ans = 0;
        vis[N] = true;
        que.offer(new point(N,0));

        while(!que.isEmpty()){

            point n = que.poll();
            if(n.p == K){
                ans = n.sec;
                break;
            }



                if(2*n.p >= 0 && 2*n.p <= 100000 && !vis[2*n.p]){
                    vis[2*n.p] = true;
                    que.offer(new point(2*n.p, n.sec));
                }

                if(n.p-1 >= 0 && n.p-1 <= 100000 && !vis[n.p-1]){
                    vis[n.p-1] = true;
                    que.offer(new point(n.p-1, n.sec+1));
                }
                if( n.p+1 >= 0 && n.p+1 <= 100000 && !vis[n.p+1]){
                    vis[n.p+1] = true;
                    que.offer(new point(n.p+1, n.sec+1));
                }

        }

        System.out.println(ans);

    } //main
}
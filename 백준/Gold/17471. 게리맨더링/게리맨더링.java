import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    static int ans;
    static boolean[] visited;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        list = new ArrayList<List<Integer>>();
        arr = new int[N+1];

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<Integer>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
           arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            for(int c = 0; c < cnt; c++){
                int node = Integer.parseInt(st.nextToken());
                list.get(i).add(node);
            }
        }
        // 부분 집합
        ans = Integer.MAX_VALUE;
        subset(1,0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    } // main

    static void subset(int cnt, int pickCnt){

        if(cnt == (N + 1)){
            if(pickCnt > 0 && pickCnt < N){
                List<Integer> listA = new ArrayList<>();
                List<Integer> listB = new ArrayList<>();
                for(int i = 1; i <= N; i++){
                    if(visited[i]){
                        //유저
                        listA.add(i);
                    }
                    else{
                        listB.add(i);
                    }

                }

                // 각각 연결 되어있는지 확인
                if(chkConnect(listA) && chkConnect(listB)){
                    int A = 0;
                    for(int i = 0; i < listA.size(); i++){
                        A += arr[listA.get(i)];
                    }

                    int B = 0;
                    for(int i = 0; i < listB.size(); i++){
                        B += arr[listB.get(i)];
                    }
                    ans = Math.min(ans, Math.abs(A - B));
                }
                else{
                    // 연결되어 있지 않다면 return;
                    return;
                }

            }
            return;
        }

        visited[cnt] = true;
        subset(cnt+1, pickCnt+1);
        visited[cnt] = false;
        subset(cnt+1, pickCnt);

    } //subset

    // bfs로 연결되어있는지 확인
    static boolean chkConnect(List<Integer> chkList){

         Queue<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[N+1];
        
        que.offer(chkList.get(0));
        vis[chkList.get(0)] = true;
        
        int count = 1;
        
        while(!que.isEmpty()){
            int node = que.poll();
            for(Integer next : list.get(node)){
                if (!vis[next] && chkList.contains(next)) {
                    vis[next] = true;
                    que.offer(next);
                    count++;
                }
            }
        }

        return count == chkList.size();

    } //chkConnect

}
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> g = new ArrayList<>();
    static int[] reach;                     // reach[i] : i가 해킹할 수 있는 컴퓨터 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        reach = new int[N + 1];
        for (int i = 0; i <= N; i++) g.add(new ArrayList<>());

        // 입력: A B  →  B → A
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            g.get(B).add(A);
        }

        // 모든 정점에서 BFS
        int max = 0;
        for (int s = 1; s <= N; s++) {
            boolean[] vis = new boolean[N + 1];
            Queue<Integer> q = new LinkedList<>();

            vis[s] = true;
            q.offer(s);

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt : g.get(cur)) {
                    if (!vis[nxt]) {
                        vis[nxt] = true;
                        reach[s]++;         // s가 한 대 더 감염
                        q.offer(nxt);
                    }
                }
            }

            max = Math.max(max, reach[s]);

        }

        //System.out.println(max);

        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(max == reach[i]){
                ans.add(i);
            }
        }

        Collections.sort(ans);

        for(int tmp : ans){
            System.out.print(tmp + " ");
        }

    }
}

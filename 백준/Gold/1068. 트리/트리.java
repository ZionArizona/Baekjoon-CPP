import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N;
    static int K;
    static int[] arr;
    static boolean[] vis;
    static List<List<Integer>> list = new ArrayList<>();
    static int zero;
    static Queue<int[]> que = new ArrayDeque<>();
    static int ans;
    static boolean flag;
    static int root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        for(int i = 0; i <= N; i++) {
        	list.add(new ArrayList<>());
        }
        
        vis = new boolean[N+1];
        root = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	int n = Integer.parseInt(st.nextToken());
        	
        	if(n == -1) {
        		root = i;
        	}
        	else {
        		list.get(n).add(i);
        		list.get(i).add(n);
        	}
        	
        }
        
        K = Integer.parseInt(br.readLine());
        
        ans = 0;
        
        if(K == root) {
        	System.out.println(0);
        }
        else {
        	dfs(root);
        	System.out.println(ans);
        }
        
    } //main

    static void dfs(int node) {
    	
    	vis[node] = true;
    	
    	//if(node == K) return;
    	
    	int cnt = 0;
		for(Integer a : list.get(node)) {
			if(a != K && !vis[a]) {
				cnt++;
				dfs(a);
			}
		}
    	
    	if(cnt == 0) {
    		ans++;
    	}
    	
    } //dfs
    
}
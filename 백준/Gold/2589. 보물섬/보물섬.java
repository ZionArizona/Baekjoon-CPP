import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N,M;
    static char[][] arr;
    static boolean[][] vis;
    static int[] drow = {-1,1,0,0};  //상    하    좌     우
    static int[] dcol = {0,0,-1,1};
    static int ans;
    static int cnt;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new char[N][M];
        vis = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
        	String str = br.readLine();
        	for(int j = 0; j < M; j++) {
        		arr[i][j] = str.charAt(j);
        	}
        }
        
        ans = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		if(arr[i][j] == 'L') {
        			bfs(i,j);
        		}
        		
        		
        	}
        }

        System.out.println(ans-1);
   
    } //main


    static void bfs(int row, int col) {
    	vis = new boolean[N][M];
    	Queue<int[]> que = new ArrayDeque<>();
    	vis[row][col] = true;
    	que.offer(new int[] {row,col,0});
    	
    	int chk = 0;
    	while(!que.isEmpty()) {
    		
    		int size = que.size();
    		chk++;
    		while(size-- > 0) {
    			int[] p = que.poll();
    			
    			for(int i = 0; i < 4; i++) {
    				
    				int nextrow = p[0] + drow[i];
    				int nextcol = p[1] + dcol[i];
    				
    				if(nextrow >= 0 && nextrow < N && nextcol >= 0 && nextcol < M && arr[nextrow][nextcol] == 'L' && !vis[nextrow][nextcol]) {
    					vis[nextrow][nextcol] = true;
    					que.offer(new int[] {nextrow,nextcol, p[2]+1});		
    				}	
    			}
    		}		
    		
    	}// while
	
    	ans = Math.max(ans, chk);

    } //bfs
}
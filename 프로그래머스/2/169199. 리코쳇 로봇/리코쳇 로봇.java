import java.util.*;
class Solution {
    
    static int[] dr = {-1,0,1,0};  // 상 좌 하 우
    static int[] dy = {0,-1,0,1};
    static int[][] dis;
    static char[][] map;
    static int m;
    static int n;
    static int x1;
    static int y1;
    static int x2;
    static int y2;
    
    public int solution(String[] board) {
        int answer = 0;
        m = board.length;
        n = board[0].length();
        map = new char[m][n];
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R'){
                    x1 = i; y1 = j;
                }
                if(map[i][j] == 'G'){
                    x2 = i; y2 = j;
                }
            }
        }
        
        //System.out.println("x1 : " + x1 + " y1 : " + y1 + " x2 : " + x2 + " y2 : " + y2);
        
        answer = bfs();
        
        return answer;
    }
    
    static int bfs(){
        Queue<int[]> que = new ArrayDeque<>();
        dis = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dis[i],-1);
        }
        dis[x1][y1] = 0;
        que.add(new int[]{x1,y1});
        
        while(!que.isEmpty()){
            int[] node = que.poll();
            
            
            if(node[0] == x2 && node[1] == y2) return dis[node[0]][node[1]];
            
            for(int i = 0; i < 4; i++){
                int nextrow = node[0];
                int nextcol = node[1];
                
                
                while(true){
                    int tmpRow = nextrow + dr[i];
                    int tmpCol = nextcol + dy[i];
                    
                    
                    if(tmpRow < 0 || tmpRow >= m || tmpCol < 0 || tmpCol >= n) break;
                    if(map[tmpRow][tmpCol] == 'D') break;
                    
                    nextrow = tmpRow;
                    nextcol = tmpCol;
                    
                }
                
                if(nextrow == node[0] && nextcol == node[1]) continue;
                
                if(dis[nextrow][nextcol] == -1){
                    dis[nextrow][nextcol] = dis[node[0]][node[1]] + 1;
                    que.add(new int[]{nextrow,nextcol});
                }
                
                
            }
            
            
        }
        return -1;
    }
    
}
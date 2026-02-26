import java.util.*;
class Solution {
    
    static int answer = 0;
    static int[] dx = {-1,0,1,0};  // 상 좌 하 우
    static int[] dy = {0,-1,0,1};
    static boolean[][] vis;
    static String[][] map;
    static int x1;
    static int y1;
    static int m1;
    static int m2;
    static int x2;
    static int y2;
    static int m;
    static int n;
    
    public int solution(String[] maps) {
        m = maps.length;
        n = maps[0].length();
        
        map = new String[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = String.valueOf(maps[i].charAt(j));
                if(map[i][j].equals("S")){
                    x1 = i; y1 = j;
                }
                if(map[i][j].equals("L")){
                    m1 = i; m2 = j;
                }
                if(map[i][j].equals("E")){
                    x2 = i; y2 = j;
                }
            }
        }
        
        
        if(Lfind()){  //L을 찾으면
            //System.out.println(answer);
            if(Exit()){
                return answer;
            }
            else{
                return -1;
            }
            
        }
        else{
            return -1;
        }
        
        
    }
    
    private static boolean Exit(){
        vis = new boolean[m][n];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{m1,m2,0});
        vis[m1][m2] = true;
        
        while(!que.isEmpty()){
            int[] node = que.poll();
        
            for(int i = 0; i < 4; i++){
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                
                if(nx == x2 && ny == y2){
                    answer += (node[2] + 1);
                    return true;   
                } 
                
                if(!map[nx][ny].equals("X") && !vis[nx][ny]){
                    vis[nx][ny] = true;
                    que.add(new int[]{nx,ny,node[2]+1});
                }                
                
            }
        
        }
        return false;
    }
    
    
    
    private static boolean Lfind(){
        vis = new boolean[m][n];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x1,y1,0});
        vis[x1][y1] = true;
        
        while(!que.isEmpty()){
            int[] node = que.poll();
        
            for(int i = 0; i < 4; i++){
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                
                if(nx == m1 && ny == m2){
                    answer = node[2] + 1;
                    return true;   
                } 
                
                if(!map[nx][ny].equals("X") && !vis[nx][ny]){
                    vis[nx][ny] = true;
                    que.add(new int[]{nx,ny,node[2]+1});
                }                
                
            }
        
        }
        
        
        
        return false;
    }
    
    
    
    
}
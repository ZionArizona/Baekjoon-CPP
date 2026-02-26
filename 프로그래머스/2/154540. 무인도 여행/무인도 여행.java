import java.util.*;
class Solution {
    
    static List<Integer> ans = new ArrayList<>();
    static int m;
    static int n;
    static String[][] map;
    static boolean[][] vis;
    static int[] dx = {-1,1,0,0}; // 상 하 좌 우
    static int[] dy = {0,0,-1,1};
    
    public int[] solution(String[] maps) {
        ans = new ArrayList<>();
        m = maps.length;
        n = maps[0].length();
        map = new String[m][n];
        vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!map[i][j].equals("X") && !vis[i][j]){
                    bfs(i,j);
                }
            }
            System.out.println();
        }
        
        Collections.sort(ans, (e1,e2)->{
           return e1-e2; 
        });
        
        int[] answer = new int[ans.size()];
        if(ans.size() == 0){
            return new int[]{-1};   
        }
        else{
            for(int i = 0; i< ans.size(); i++){
                answer[i] = ans.get(i);
            }
        }
        
        return answer;
    }
    
    static void bfs(int x, int y){
        int answer = Integer.parseInt(map[x][y]);
        vis[x][y] = true;
        Queue<int[]> que = new ArrayDeque<>();
        
        que.add(new int[]{x,y});
        
        while(!que.isEmpty()){
            int[] node = que.poll();
            
            for(int i = 0 ; i < 4; i++){
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(vis[nx][ny]) continue;
                if(map[nx][ny].equals("X")) continue;
                
                answer += Integer.parseInt(map[nx][ny]);
                vis[nx][ny] = true;
                que.add(new int[]{nx,ny});
            }
        }
        
        ans.add(answer);
    }
    
}
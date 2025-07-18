class Solution {
    static int[] answer;
    static int[] discount = {10,20,30,40};
    static int[] idxDis;
    static int elen;
    static int[] emoti;
    static int[][] user;
    static int count = 0;
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        elen = emoticons.length;
        answer = new int[2];
        idxDis = new int[elen];
        user = users;
        emoti = emoticons;
        
        dfs(0);
        
        //System.out.println(answer[0] + " " + answer[1]);
//         for(int i = 0; i < user.length; i++){
                
//                 System.out.println(user[i][0] + "" + user[i][1]);
//         }
        
        //System.out.println(elen);
        
        //System.out.println(count);
        
        return answer;
    }
    
    
    static void dfs(int cnt){
        
        if(cnt == elen){
            
            count++;
            int regist = 0;
            int money = 0;
            
            for(int i = 0; i < user.length; i++){
                int tmpMoney = 0;
                for(int j = 0; j < elen; j++){
                    if(idxDis[j] < user[i][0]) continue;
                    else{
                        tmpMoney += (emoti[j] - (int)(emoti[j]*idxDis[j]/100) );           
                    }
                }
                
                
                if(tmpMoney >= user[i][1]){
                    regist++;
                } 
                else{
                    money += tmpMoney;
                }
                
            }
            
            if(answer[0] < regist){
                answer[0] = regist;
                answer[1] = money;
            }
            else if(answer[0] == regist){
                if(answer[1] < money){
                    answer[1] = money;
                }
            }
            
            
            //System.out.println(answer[0] + " " + answer[1]);
            
            
            // for(int i = 0; i < elen; i++){
            //     System.out.print(idxDis[i] + " ");
            // }
            // System.out.println();
            // System.out.println();
            
            return;
        }
        
        
        
        for(int i = 0; i < 4; i++){
            idxDis[cnt] = discount[i];
            dfs(cnt+1);
        }
        
    }
    
    
}
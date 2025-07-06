import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] list = new int[n+1];
        
        Arrays.fill(list,1);
        
        for(int i = 0; i < reserve.length; i++){
            list[reserve[i]] = 2;
        }
        
        for(int i = 0; i < lost.length; i++){
            if(list[lost[i]] == 2){
                list[lost[i]] = 1;
            }
            else{
                list[lost[i]] = 0;
            }
        }
        
        
        
        for(int i = 1; i < list.length; i++){
            
            if(list[i] == 0 || list[i] == 1) continue;
            
            if(list[i] == 2){
                if(i == 1){
                    if(list[i+1] == 0){
                        list[i + 1] = 1;
                        list[i] -= 1;
                    }
                }
                else if(i == n){
                    if(list[i-1] == 0){
                        list[i-1] = 1;
                        list[i] -= 1;
                    }
                }
                else{
                    if(list[i-1] == 0){
                        list[i-1] = 1;
                        list[i] -= 1;
                    }
                    else if(list[i+1] == 0){
                        list[i+1] = 1;
                        list[i] -= 1;
                    }
                }
            }
        }
        
        
        for(int i = 1; i < list.length; i++){
            if(list[i] == 1 || list[i] == 2) answer++;
        }
        
        
        
        // for(int i = 1; i < list.length; i++){
        //     System.out.println(i + " " + list[i]);
        // }
        
        
        
        
        
        
        return answer;
    }
}
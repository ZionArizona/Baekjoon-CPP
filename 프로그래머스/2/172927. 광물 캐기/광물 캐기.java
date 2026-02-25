import java.util.*;
class Solution {
    
    public static class Group{
        int d;
        int i;
        int s;
        int total;
        
        Group(int d, int i, int s){
            this.d = d;
            this.i = i;
            this.s = s;
            this.total = 25*d + 5 * i + s;
        }
        
    }
    
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<Group> list = new ArrayList<>();
        int maxrange = 0;
        if(5*(picks[0] + picks[1] + picks[2]) < minerals.length){
            maxrange = 5 * (picks[0] + picks[1] + picks[2]);
        }
        else{
            maxrange = minerals.length;
        }
        
        //System.out.println(maxrange);
        
        for(int i = 0; i < maxrange; i += 5){
            int d = 0, ir = 0, s = 0;
            for(int j = i; j < i+5 && j < maxrange; j++){
                if(minerals[j].equals("diamond")) d++;
                if(minerals[j].equals("iron")) ir++;
                if(minerals[j].equals("stone")) s++;
            }
            list.add(new Group(d,ir,s));
        }
        
        Collections.sort(list, (e1,e2) -> {
            return e2.total - e1.total;
        });
        
        for(Group g : list){
            System.out.println(g.total);
        }
        
        
        
        for(Group g : list){
            
            if(picks[0] > 0){
                picks[0]--;
                answer += (g.d + g.i + g.s);
            }
            else if(picks[1] > 0){
                picks[1]--;
                answer += (5*g.d + g.i+ g.s);
            }
            else if(picks[2] > 0){
                picks[2]--;
                answer += (25*g.d + 5*g.i + g.s);
            }
            
            
        }
        
        
        return answer;
    }
}
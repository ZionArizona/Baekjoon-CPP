import java.util.*;
class Solution {
    
    static class Task{
        String name;
        int start;
        int play;
        Task(String name, int start, int play){
            this.name = name;
            this.start = start;
            this.play = play;
        }
        Task(String name, int play){
            this.name = name;
            this.play = play;
        }
    }
    public List<String> solution(String[][] plans) {
        List<String> ans = new ArrayList<>();
        Queue<Task> que = new ArrayDeque<>();
        Stack<Task> stack = new Stack<>();
        Arrays.sort(plans, (e1,e2)->{
           return e1[1].compareTo(e2[1]); 
        });
        for(int i = 0; i < plans.length; i++){
            que.add(new Task(plans[i][0], intConvert(plans[i][1]), Integer.parseInt(plans[i][2])));                   
        }
        
        while(!que.isEmpty()){
            Task curTask = que.poll();
            int curTime = curTask.start;
            
            if(!que.isEmpty()){
                Task nextTask = que.peek();
                
                if(curTime + curTask.play <= nextTask.start){
                    ans.add(curTask.name);
                    curTime += curTask.play; 
                    
                    while(!stack.isEmpty()){
                        Task rem = stack.pop();
                        if(curTime + rem.play <= nextTask.start){
                            ans.add(rem.name);
                            curTime += rem.play;
                        }
                        else{
                            stack.add(new Task(rem.name, rem.play- (nextTask.start-curTime)));
                            break;
                        }
                    }
                }
                else{
                    stack.add(new Task(curTask.name, curTask.play - (nextTask.start-curTask.start)));
                }     
            }
            else{
                if(stack.isEmpty()){
                    ans.add(curTask.name);
                    break;
                }
                else{
                    ans.add(curTask.name);
                    while(!stack.isEmpty()){
                        Task tmp = stack.pop();
                        ans.add(tmp.name);
                    }
                }
            }
        }
        
        
        
        return ans;
    }
    
    static int intConvert(String time){
        return Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(3,5));
    }
}
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1;
        int right = 0;
        for(int i = 0; i < diffs.length; i++){
            right = Math.max(right,diffs[i]);
        }
        //System.out.println(right);
        
        while(left<=right){
            int mid = (left+right)/2;
            long sum = 0;
            for(int i = 0; i < diffs.length;i++){
                
                if(diffs[i] <= mid){
                    sum+=times[i];
                }
                else{
                    //sum += (times[i] + (times[i]*times[i-1])*(diffs[i]-mid));
                    sum += (long)(times[i - 1] + times[i]) * (diffs[i]-mid) + times[i];
                }
            }
            
            if(sum > limit){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
            
        }
        
        
        
        return left;
    }
}
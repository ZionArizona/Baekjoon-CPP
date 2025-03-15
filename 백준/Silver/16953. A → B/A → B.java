import java.util.*;
import java.io.*;

public class Main {
	
	static long A,B;
	static Queue<Point> que = new ArrayDeque<>();
	static Set<Long> set = new HashSet<>();
	static private class Point{
	    long num;
	    long cnt;

	    private Point(long num, long cnt){
	        this.num = num;
	        this.cnt = cnt;
	    }

	}
	
	
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    A = Long.parseLong(st.nextToken());
	    B = Long.parseLong(st.nextToken());
	    
	    que.offer(new Point(A,0));
	    set.add(A);
	    long ans = -1;
	    
	    while(!que.isEmpty()) {
	    	
	    	Point p = que.poll();
	    	
	    	long num = p.num;
	    	long cnt = p.cnt;
	    	
	    	if(num > B) continue;
	    	
	    	if(num == B) {
	    		ans = cnt;
	    		break;
	    		
	    	}
	    	else {
	    		
	    		if(!set.contains(num*2)) {
	    			que.offer(new Point(num*2,cnt+1));
	    			set.add(num*2);
	    		}
	    		if(!set.contains(10*num+1)) {
	    			que.offer(new Point(10*num+1, cnt+1));
	    			set.add(10*num + 1);
	    		}
	    		
	    	}
	    }
	    
	    if(ans == -1) {
	    	System.out.println(ans);
	    }
	    else {
	    	System.out.println(ans+1);
	    }
	    
	} // main

}
import java.util.*;
import java.io.*;


public class Main {
	static int count;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		count = 0;
		
		
		for(int i = 0; i < N; i++) {
			
			Stack<Character> stack = new Stack();
			
			int idx = 0;
			
			String check = br.readLine();
			
			while(idx < check.length()) {
				if(stack.isEmpty()) {
					stack.push(check.charAt(idx));
					idx++;
				}
				else if(!stack.isEmpty()) {
					char ch = stack.peek();
					if(ch == check.charAt(idx)) {
						stack.pop();
						idx++;
					}
					else {
						stack.push(check.charAt(idx));
						idx++;
					}
					
				}
			}
			
			if(stack.isEmpty()) {
				count++;
			}
			
		}
		
		System.out.println(count);
		

	}

}

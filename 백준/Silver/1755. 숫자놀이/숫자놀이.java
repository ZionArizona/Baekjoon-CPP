import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] num = {"zero", "one","two","three","four","five","six","seven","eight","nine"};
		
		List<String> list = new ArrayList<>();
		
		
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		//System.out.println(m + "    " + n);
		
		
		
		for(int i = m ; i<= n; i++) {
			String ans = "";
			String st1 = String.valueOf(i);
			for(int idx = 0; idx < st1.length(); idx++) {
				int c = st1.charAt(idx) - '0';
				
				
				
				ans += num[c] + " ";
			}
			
			list.add(ans);
		}
		
		
		Collections.sort(list);
		
		List<Integer> a = new ArrayList<>();
		
		for(String s : list) {
			String[] str = s.split(" ");
			//System.out.println(Integer.parseInt(""));
			if(str.length == 2) {
				int one = 0;
				int two = 0;
				if(str[0].equals("one")) {
					one =1;
				}else if(str[0].equals("two")) {
					one = 2;
					
				}
				else if(str[0].equals("three")) {
					one = 3;
					
				}
				else if(str[0].equals("four")) {
					one = 4;
					
				}
				else if(str[0].equals("five")) {
					one = 5;
					
				}
				else if(str[0].equals("six")) {
					one = 6;
					
				}
				else if(str[0].equals("seven")) {
					one = 7;
					
				}
				else if(str[0].equals("eight")) {
					one = 8;
					
				}
				else if(str[0].equals("nine")) {
					one = 9;
					
				}
				
				
				//
				if(str[1].equals("one")) {
					two =1;
				}else if(str[1].equals("two")) {
					two = 2;
					
				}
				else if(str[1].equals("three")) {
					two = 3;
					
				}
				else if(str[1].equals("four")) {
					two = 4;
					
				}
				else if(str[1].equals("five")) {
					two = 5;
					
				}
				else if(str[1].equals("six")) {
					two = 6;
					
				}
				else if(str[1].equals("seven")) {
					two = 7;
					
				}
				else if(str[1].equals("eight")) {
					two = 8;
					
				}
				else if(str[1].equals("nine")) {
					two = 9;
					
				}
				
				a.add(10*one + two);
			}
			else if(str.length == 1) {
				int one = 0;

				if(str[0].equals("one")) {
					one =1;
				}else if(str[0].equals("two")) {
					one = 2;
					
				}
				else if(str[0].equals("three")) {
					one = 3;
					
				}
				else if(str[0].equals("four")) {
					one = 4;
					
				}
				else if(str[0].equals("five")) {
					one = 5;
					
				}
				else if(str[0].equals("six")) {
					one = 6;
					
				}
				else if(str[0].equals("seven")) {
					one = 7;
					
				}
				else if(str[0].equals("eight")) {
					one = 8;
					
				}
				else if(str[0].equals("nine")) {
					one = 9;
					
				}
				
				a.add(one);
				
			}
			
		}
		
		
		for(int i = 0; i < a.size(); i++) {
			
			
			System.out.print(a.get(i) + " ");
			if(i == 9 || i == 19  || i == 29 || i == 39 || i == 49 || i == 59 || i== 69 || i==79 || i == 89 || i == 99) System.out.println();

		}
		
	}

}
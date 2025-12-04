import java.util.*;
import java.io.*;


public class Main {
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < T; k++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			List<Integer> list = new ArrayList<>();
			
			for(int i = 1; i <= 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j < num; j++) {
					if(i==6) {
						list.add(9);
					}
					else {
						list.add(i);
					}
				}
			}
			
			simul(list);
			System.out.println();
			
		}
		
	}
	
	
	static void simul(List<Integer> list) {
		
		
		Collections.sort(list, (e1,e2)->{
			return Integer.compare(e2, e1);
		});
		
		int[] number = new int[list.size()];
		
		int left = 0;
		int right = list.size() - 1;
		
		
		for(int i = 0; i < list.size(); i++) {
			
			if(i%2 == 0) {
				number[left] = list.get(i);
				left++;
			}
			else {
				number[right] = list.get(i);
				right--;
			}
			
			
			
			
		}
		
		
		for(int num : number) {
			System.out.print(num + " ");
		}

		
	}

}

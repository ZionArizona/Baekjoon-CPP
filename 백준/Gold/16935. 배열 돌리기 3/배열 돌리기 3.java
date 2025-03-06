import java.util.*;
import java.io.*;


public class Main {
	
	
	static int[][] arr;
	static int[][] tmp;
	
	static StringBuilder sb;
	static int row;
	static int col;
	static int R;
	
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[row][col];
		
		
		for(int i = 0;  i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < R; i++) {
			int c = Integer.parseInt(st.nextToken());
			if(c == 1) {
				go1();
			}
			else if(c == 2) {
				go2();
			}
			else if(c == 3) {
				arr = go3();
			}
			else if(c == 4) {
				arr = go4();
			}
			else if(c == 5) {
				arr = go5();
			}
			else if(c == 6) {
				arr = go6();
			}
			
//			for(int k = 0; k < arr.length; k++) {
//				for(int j = 0; j < arr[0].length; j++) {
//					sb.append(arr[k][j] + " ");
//				}
//				sb.append("\n");
//			}
//
//			sb.append("\n");
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	} //main
	
	static int[][] go6(){
		tmp = new int[arr.length][arr[0].length];
		
		int rowSize = arr.length;
		int colSize = arr[0].length;
		
		int rownext = rowSize/2;
		int colnext = colSize/2;
		
		// 1번 그룹 4번 옮기기
		for(int i = 0; i < rownext; i++) {
			for(int j = 0; j < colnext; j++) {
				tmp[i+rownext][j] = arr[i][j];
			}
		}
		
		
		// 4번 그룹 3번 옮기기
		for(int i = rownext; i < rowSize; i++) {
			for(int j = 0; j < colnext; j++) {
				tmp[i][j+colnext] = arr[i][j];
			}
		}
		
		// 3번 그룹 2번 옮기기
		for(int i = rownext; i < rowSize; i++) {
			for(int j = colnext; j < colSize; j++) {
				tmp[i- rownext][j] = arr[i][j];
			}
		}
		
		// 2번 그룹 1번 옮기기
		for(int i = 0; i < rownext; i++) {
			for(int j = colnext; j < colSize; j++) {
				tmp[i][j-colnext] = arr[i][j];
			}
		}
		
		
		return tmp;
	}
	
	
	static int[][] go5() {
		tmp = new int[arr.length][arr[0].length];
		
		int rowSize = arr.length;
		int colSize = arr[0].length;
		
		int rownext = rowSize/2;
		int colnext = colSize/2;
		
		// 1번 그룹 2번으로 옮기기
		for(int i = 0; i < rownext; i++) {
			for(int j = 0; j < colnext; j++) {
				tmp[i][j+colnext] = arr[i][j];
				
			}
		}
		
		// 2번 그룹을 3번으로 옮기기
		for(int i = 0; i < rownext; i++) {
			for(int j = colnext; j < colSize; j++) {
				tmp[i+rownext][j] = arr[i][j];
				
			}
		}
		
		// 3번 그룹을 4번으로 옮기기
		for(int i = rownext; i < rowSize; i++) {
			for(int j = colnext; j < colSize; j++) {
				tmp[i][j-colnext] = arr[i][j];
			}
		}
		
		// 4번 그룹 1번으로 옮기기
		for(int i = rownext; i < rowSize; i++) {
			for(int j = 0; j < colnext; j++) {
				tmp[i-rownext][j] = arr[i][j];
			}
		}
		
		return tmp;
	} //go5
	
	
	static int[][] go4(){ // 왼쪽 90 회전
		tmp = new int[arr[0].length][arr.length];
		
		for(int i = 0 ; i < arr.length; i++) {
			
			for(int j = 0 ; j < arr[0].length; j++) {
				tmp[arr[0].length -1 - j][i] = arr[i][j];
			}
			
		}
		
		return tmp;
	} //go4
	
	
	static int[][] go3() { // 오른쪽 90도 회전
		tmp = new int[arr[0].length][arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr[0].length; j++) {
				
				tmp[j][arr.length - i - 1] = arr[i][j];
				
			}
			
		}
		
		
		return tmp;
	} //go3
	
	
	static void go2() {  //좌우 반전
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length/2; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][arr[0].length-1-j];
				arr[i][arr[0].length-1-j] = tmp;
			}
		}
		
	}  // go2
	
	
	

	static void go1() { // 상하 반전.
		
		for(int i = 0; i < arr[0].length; i++) {
			for(int j = 0 ; j < arr.length/2; j++) {
				int tmp = arr[j][i];
				arr[j][i] = arr[arr.length-j-1][i];
				arr[arr.length-j-1][i] = tmp;
			}
		}
	} //go1
	
}
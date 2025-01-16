import java.util.*;
import java.io.*;


public class Main
{
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][M];
        
        boolean[][] chk = new boolean[N][M];
        int top_row = 0;
        int top_col = 0;
        int bot_row = 0;
        int bot_col = 0;
        int count = 0;
        
		for(int i = 0; i < N; i++){
		    String[] str = br.readLine().split(" ");
		    for(int j = 0; j < M; j++){
		        arr[i][j] = Integer.parseInt(str[j]);
		        if(arr[i][j] == -1)
		        {
		            count += 1;
		            if(count == 1){
		                top_row = i;
		                top_col = j;
		            }
		            else if(count == 2){
		                bot_row = i;
		                bot_col = j;
		            }
		            chk[i][j] = true;
		        }
		  
		    }
		}
		
		
		for(int t = 0; t < T; t++){
		    int[][] arr1 = new int[N][M];
    	    // 먼지 확산 계산.
    	    for(int i = 0; i < N; i++){
    		    for(int j = 0; j < M; j++){
    		        if(arr[i][j] == 0 || arr[i][j] == -1) continue;
    		        else{
    		            //왼
    		            int a = arr[i][j]/5;
    		            if( (j-1 >= 0) && arr[i][j-1] != -1){
    		                //arr[i][j-1] += arr[i][j]/5;
    		                arr1[i][j-1] += a;
    		                arr[i][j] -= a;
    		                
    		            }
    		            // 오른쪽
    		            if((j+1 < M) && arr[i][j+1] != -1){
    		                //arr[i][j+1] += arr[i][j]/5;
    		                arr1[i][j+1] += a;
    		                arr[i][j] -= a;
    		            }
    		            //위
    		            if((i-1 >= 0) && arr[i-1][j] != -1){
    		                //arr[i-1][j] += arr[i][j]/5;
    		                arr1[i-1][j] += a;
    		                arr[i][j] -= a;
    		            }
    		            // 아래
    		            if((i+1 < N) && arr[i+1][j] !=-1){
    		                //arr[i+1][j] += arr[i][j]/5;
    		                arr1[i+1][j] += a;
    		                arr[i][j] -= a;
    		            }
    		        }
    		        
    		        
    		    }
    		}
    		
    		for(int i = 0; i < N; i++){
    		    for(int j = 0; j < M; j++){
                    arr[i][j] += arr1[i][j];
    		    }
    		}
    		
    				// 공기 청정기 움직임
    		//1. 반시계 방향
    		//1-1 아래
    		int upper = top_row;
    		for(int i = upper - 1; i > 0; i--){
    		    arr[i][0] = arr[i-1][0];
    		}
    		//1-2 왼쪽
    		for(int i = 0; i < M - 1; i++){
    		    arr[0][i] = arr[0][i+1];
    		}
    		//1-3 위로
    		for(int i = 0; i < top_row; i++){
    		    arr[i][M-1] = arr[i+1][M-1];
    		}
    		//1-4. 오른쪽
            for(int i = M - 1; i > 1; i--){
                arr[upper][i] = arr[upper][i-1];
            }
            arr[upper][1] = 0;
            
            
            //2.시계
    		int lower = bot_row;
    		//위로
    		for(int i = lower + 1; i < N - 1; i++){
    		    arr[i][0] = arr[i+1][0];
    		}
    		//왼쪽
    		for(int i = 0; i < M -1; i++){
    		    arr[N-1][i] = arr[N-1][i+1];
    		}
    		//아래
    		for(int i = N -1; i > lower; i--){
    		    arr[i][M-1] = arr[i-1][M-1];
    		}
    		//오른쪽
            for(int i = M -1; i > 1; i--){
                arr[lower][i] = arr[lower][i-1];
            }
		    
		    arr[lower][1] = 0;
		}
		
		
		
// 	    System.out.println();
// 	    System.out.println();
		
		
		
// 		for(int i = 0; i < N; i++){
// 		    for(int j = 0; j < M; j++){
// 		        System.out.print(arr[i][j] + " ");
// 		    }
// 		    System.out.println();
// 		}
		
		
		int ans = 0;
		
		for(int i = 0; i < N; i++){
		    for(int j = 0; j < M; j++){
		        ans += arr[i][j];
		    }
		}
		
	    System.out.println(ans+2);
		
		
	}
}

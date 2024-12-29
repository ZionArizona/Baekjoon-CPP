import java.util.*;
import java.io.*;


class Solution
{
    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int k = 1; k <= T; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] arrA = new int[A];
            int[] arrB = new int[B];

            String [] strA = br.readLine().split(" ");
            String [] strB = br.readLine().split(" ");

            for(int i = 0; i < strA.length; i++){
                arrA[i] = Integer.parseInt(strA[i]);
            }

            for(int i = 0; i < strB.length; i++){
                arrB[i] = Integer.parseInt(strB[i]);
            }

            int ans = Integer.MIN_VALUE;

            if(A > B){

                for(int i = 0; i <= (A-B); i++){
                    int chk = 0;
                    for(int j = 0; j < B; j++){
                        chk += arrB[j] * arrA[i+j];
                    }
                    if(ans <= chk){
                        ans = chk;
                    }
                }
            }
            else{
                for(int i = 0; i <= (B-A); i++){
                    int chk = 0;
                    for(int j = 0; j < A; j++){
                        chk += arrA[j] * arrB[i+j];
                    }
                    if(ans <= chk){
                        ans = chk;
                    }
                }
            }
            System.out.println("#"+ k + " " + ans);
        }

    }
}
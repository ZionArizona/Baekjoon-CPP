import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int[] ans;
    static boolean[] index;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ans = new int[n];
        index = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        for(int i = 0; i < n; i++){
//            System.out.print(arr[i] + " ");
//        }

        // 각 숫자 자리를 탐색
        for(int i = 0; i < n; i++){
            int num = i + 1;

            for(int idx = 0; idx < n; idx++){

                int cnt = 0;
                if(idx == 0){
                    cnt = 0;
                }
                else{
                    for(int j = 0; j < idx; j++){
                        if(index[j] == false){
                            cnt++;
                        }
                    }
                }

                if(cnt == arr[i] && index[idx] == false){

                    index[idx] = true;
                    ans[idx] = num;
                    //System.out.println(cnt + " " + idx + " " + i);
                    break;
                }


            }
        }

        for(Integer num : ans){
            System.out.print(num + " ");
        }


    } // main

}
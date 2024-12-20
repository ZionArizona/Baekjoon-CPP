import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());



        int[] Arr = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 1000000;
        int max = -1000000;
        for(int i = 0; i < N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            if(Arr[i] < min){
                min = Arr[i];
            }
            if(Arr[i] > max){
                max = Arr[i];
            }
        }

        System.out.println(min + " " + max);
    }
}

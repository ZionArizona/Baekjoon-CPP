import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[] arr = new int[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }


        for(int i = 0; i < M; i++){
            str = br.readLine().split(" ");
            int fir = Integer.parseInt(str[0]);
            int sec = Integer.parseInt(str[1]);
            int temp = arr[fir];
            arr[fir] = arr[sec];
            arr[sec] = temp;
        }

        for(int i = 1; i <= N; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

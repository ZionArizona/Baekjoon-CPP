import java.util.*;
import java.io.*;

public class Main {

    static int N, d, k, c;
    static int[] arr;
    static int[] count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N];
        count = new int[d+1];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int type = 0;
        for(int i = 0; i < k; i++){
            if(count[arr[i]] == 0) type++;
            count[arr[i]]++;
        }

        int max = 0;
        if(count[c] == 0) {
            max = type+1;
        }
        else{
            max = type;
        }

        for(int i = 1; i < N; i++){
            int tmp = 0;
            int remove = arr[i - 1];
            int add = arr[(i+k-1)%N];

            count[remove]--;
            if(count[remove] == 0) type--;

            if(count[add] == 0) type++;
            count[add]++;

            if(count[c] == 0) {
                tmp = type+1;
            }
            else{
                tmp = type;
            }

            max = Math.max(max, tmp);

        }

        System.out.println(max);

    } // main
}
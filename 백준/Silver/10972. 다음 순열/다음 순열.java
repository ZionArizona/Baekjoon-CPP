import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(nextPermutation()){
            for(int i = 0; i < N; i++){
                System.out.print(arr[i] + " ");
            }
        }else{
            System.out.println(-1);
        }

    } //main

    public static boolean nextPermutation(){

        int i = N-1;
        while(i > 0 && arr[i]  < arr[i-1]){
            i--;
        }

        if(i == 0) return false;

        int j = N - 1;
        while(j > i && arr[j] < arr[i-1]){
            j--;
        }

        swap(i,j);
        
        Arrays.sort(arr,i,N);

        return true;
    } //nextPermutation

    public static void swap(int i, int j){

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

    } //swap
}
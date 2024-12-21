import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        String[] str = br.readLine().split(" ");
        int Max = 0;

        for(int i = 0; i < str.length; i++){
            arr[i] = Integer.parseInt(str[i]);
            if(arr[i] > Max){
                Max = arr[i];
            }
        }

        double sum = 0;
        double[] arr1 = new double[N];
        for(int i = 0; i < N; i++){
            arr1[i] = ((double)arr[i]/Max)*100;
            sum += arr1[i];
        }

        System.out.println(sum/N);

    }
}

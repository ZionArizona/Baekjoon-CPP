import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] arr = new int[27];

        for(int i = 0; i < arr.length; i++){
            arr[i] = -1;
        }

        for(int i = 0; i < str.length(); i++){
            if(arr[str.charAt(i) - 'a'] == -1){
                arr[str.charAt(i) - 'a'] = i;
            }
        }

        for(int i = 0; i <= 25; i++){
            System.out.print(arr[i] + " ");
        }

    }
}

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int chk = Integer.parseInt(br.readLine());

        int count = 0;

        for(int i = 0; i < N; i++){
            if(chk == Integer.parseInt(str[i])){
                count++;
            }
        }
        System.out.println(count);

    }
}

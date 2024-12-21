import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        for(int i = 0; i < N; i++){
            String[] st = br.readLine().split(" ");
            int num = Integer.parseInt(st[0]);
            String str = st[1];

            String ans = "";
            
            for(int j = 0; j < str.length(); j++){
                for(int k = 0; k < num; k++){
                    ans += str.charAt(j);
                }
            }

            System.out.println(ans);

        }

    }
}

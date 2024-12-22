import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            boolean[] flag = new boolean[26];
            for(int j = 0; j < str.length(); j++){
                if((j == str.length() - 1) && ((flag[str.charAt(j) - 'a'] == false) || (flag[str.charAt(j) - 'a'] == true && str.charAt(j) == str.charAt(j-1)) )){
                    ans++;
                }
                else if((flag[str.charAt(j) - 'a'] == false)){
                    flag[str.charAt(j) - 'a'] = true;
                    continue;
                }
                else if((flag[str.charAt(j) - 'a'] == true) && (str.charAt(j) != str.charAt(j-1))){
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}

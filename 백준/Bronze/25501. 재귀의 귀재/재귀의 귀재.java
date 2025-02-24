import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main {

    static int ans = 0;
    public static int recursion(String s, int l, int r){
        ans++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            System.out.println(isPalindrome(str) + " " + ans);
            ans = 0;
        }

    }

}
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().strip();

        String[] ans = str.split(" ");

        if(ans[0] == ""){
            System.out.println(0);
        }
        else{
            System.out.println(ans.length);
        }

    }
}

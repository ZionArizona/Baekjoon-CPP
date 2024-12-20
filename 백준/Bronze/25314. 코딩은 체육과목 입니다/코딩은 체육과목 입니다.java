import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int rep = N/4;
        String ans = "";
        for(int i = 0; i < rep; i++){
            ans += "long ";
        }
        ans += "int";
        System.out.println(ans);
    }
}


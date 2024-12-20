import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int chk = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int price = 0;
        int num = 0;
        int ans = 0;
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");

            price = Integer.parseInt(str[0]);
            num = Integer.parseInt(str[1]);
            ans += price * num;

        }
        if(chk == ans){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }

    }
}


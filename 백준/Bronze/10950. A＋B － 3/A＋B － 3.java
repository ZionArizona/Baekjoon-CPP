import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int A = 0;
        int B = 0;

        for(int i = 0; i < T; i++){
            String[] str = br.readLine().split(" ");
            A = Integer.parseInt(str[0]);
            B = Integer.parseInt(str[1]);
            System.out.println(A+B);
        }

    }
}


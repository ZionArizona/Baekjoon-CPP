import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            if( A == 0 && B == 0){
                break;
            }
            System.out.println(A + B);

        }

    }
}

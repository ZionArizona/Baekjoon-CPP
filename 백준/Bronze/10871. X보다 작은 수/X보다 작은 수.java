import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        String[] A = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            if(X > Integer.parseInt(A[i])){
                System.out.print(A[i] + " ");
            }
        }

    }
}

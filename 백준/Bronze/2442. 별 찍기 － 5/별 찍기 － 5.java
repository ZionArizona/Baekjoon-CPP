import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

            for(int i = 0; i < N; i++){
                for(int b = 0; b < N-i-1; b++){
                    System.out.print(" ");
                }

                for(int s = 0; s < 2*i+1; s++){
                    System.out.print("*");
                }
                System.out.println();
            }

    } // main
}
import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

            for(int i = N; i > 1; i--){
                for(int b = 0; b < N - i; b++){
                    System.out.print(" ");
                }

                for(int c = 0; c < 2*i - 1; c++){
                    System.out.print("*");
                }
                System.out.println();
            }

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
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= N - 1; i++) {
            int num = (2 * N - 1) / 2;
            for (int j = 0; j < num - i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0; i < 2*N -1; i++){
            System.out.print("*");
        }
        System.out.println();

        for (int i = N-1; i >= 1; i--) {
            int num = (2 * N - 1) / 2;
            for (int j = 0; j <= num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Per(0,2);
        Per(0,3);
        Per(0,5);
        Per(0,7);

    }

    public static void Per(int cnt, int num) {

        if(cnt == N-1){

            System.out.println(num);

            return;
        }


        for (int i = 0; i <= 9; i++) {

            if (chk(num * 10 + i)) { //소수인지 아닌지 체크
                Per(cnt + 1, num * 10 + i);
            }
        }

    } //Per

    public static boolean chk(int num) {

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num %i == 0){
                return false;
            }
        }

        return true;
    } // chk

}
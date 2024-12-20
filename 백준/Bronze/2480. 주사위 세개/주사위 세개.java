import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int fir = Integer.parseInt(str[0]);
        int sec = Integer.parseInt(str[1]);
        int thi = Integer.parseInt(str[2]);

        if (fir == sec && sec == thi){
            System.out.println(10000 + fir * 1000);
        }
        else if(fir == sec && sec != thi){
            System.out.println(1000 + fir * 100);
        }
        else if(fir == thi && sec != thi){
            System.out.println(1000 + fir * 100);
        }
        else if(sec == thi && fir != sec){
            System.out.println(1000 + sec * 100);
        }
        else{
            int max = Math.max(fir,Math.max(sec,thi));
            System.out.println(max * 100);
        }

    }
}


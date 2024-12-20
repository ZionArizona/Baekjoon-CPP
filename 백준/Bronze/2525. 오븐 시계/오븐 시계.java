import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int time = Integer.parseInt(br.readLine());

        int Hour = Integer.parseInt(str[0]);
        int Min = Integer.parseInt(str[1]);

        Hour = (Hour + (Min + time)/60)%24;
        Min = (Min + time)%60;

        System.out.println(Hour + " " + Min);
        
    }
}


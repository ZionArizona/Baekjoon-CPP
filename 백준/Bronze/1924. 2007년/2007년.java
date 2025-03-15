import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[][] day = {{}, {"SUN","MON","TUE","WED","THU","FRI","SAT"},
                        {"WED", "THU", "FRI", "SAT", "SUN", "MON", "TUE"},
                        {"WED", "THU", "FRI", "SAT", "SUN", "MON", "TUE"},
                        {"SAT", "SUN", "MON", "TUE", "WED", "THU", "FRI"},
                        {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"},
                        {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"},
                        {"SAT", "SUN", "MON", "TUE", "WED", "THU", "FRI"},
                        {"TUE", "WED", "THU", "FRI", "SAT", "SUN", "MON"},
                        {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"},
                        {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"},
                        {"WED", "THU", "FRI", "SAT", "SUN", "MON", "TUE"},
                        {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"}};


        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.println(day[x][y%7]);

    } // main
}
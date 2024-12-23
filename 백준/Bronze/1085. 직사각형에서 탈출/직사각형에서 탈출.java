import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int left = x;
        int right = (w-x);
        int bot = y;
        int top = (h-y);

        int ans = Math.min(left,Math.min(right,Math.min(bot,top)));

        System.out.println(ans);
    }
}
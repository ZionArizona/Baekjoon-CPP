import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans = 0;
        while(Integer.bitCount(N) > K){
            ans++;
            N++;
        }
        System.out.println(ans);

    } //main
}
import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {

    static int N,M;
    static String str;
    static int ans;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        str = br.readLine();
        ans = 0;
        if(2*N > M) {
            System.out.println(0);
            return;
        }

        int until = M - (2*N + 1);

        int i = 0;
        while(i <= until) {

            if(str.charAt(i) == 'I') {

                if(chk(i)){
                    //System.out.println(i);
                    ans++;
                }
            }
            i++;
        }

        System.out.println(ans);
    } //main


    static boolean chk(int idx){
        //System.out.println(idx);
        Queue<Character> que = new ArrayDeque<>();
        for(int start = idx; start < idx + (2*N+1); start++){
            que.offer(str.charAt(start));
        }

        int i = 0;

        while(!que.isEmpty()){

            char chk = que.poll();
            if(i%2 == 0 && chk != 'I'){
                return false;
            }
            if(i%2 != 0 && chk != 'O'){
                return false;
            }
            i++;

            //System.out.print(chk + " ");

        }
        //System.out.println();
        return true;
    }

}
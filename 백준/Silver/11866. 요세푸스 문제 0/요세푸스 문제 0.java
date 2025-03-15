import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static List<Point> list;

    static private class Point{

        int num;
        boolean flag;

        Point(int num, boolean flag){
            this.num = num;
            this.flag = flag;
        }
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            list.add(new Point(i,false));
        }

        List<Integer> ans = new ArrayList<>();

        int chk = 0;
        int tmp = 0;

        while(true){

            if(tmp == N) break;

            for(Point m : list){


                if(m.flag == false){
                    chk++;
                }

                if(chk == K){
                    tmp++;
                    ans.add(m.num);
                    m.flag = true;
                    chk = 0;
                }
            }
        }

        String str = "<";

        for(int i = 0; i < N - 1; i++){
            str += ans.get(i) + ", ";
        }

        str += ans.get(N-1) + ">";

        System.out.println(str);

    } // main

}
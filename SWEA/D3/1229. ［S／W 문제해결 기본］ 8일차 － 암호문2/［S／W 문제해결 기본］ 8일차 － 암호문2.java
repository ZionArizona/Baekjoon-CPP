import java.util.*;
import java.io.*;

public class Solution {

    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test = 1; test <= 10; test++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());


            list = new ArrayList<>();

            for(int i = 0; i < N; i++){
                list.add(st.nextToken());
            }

            int InstructNum = Integer.parseInt(br.readLine());

            String[] instruct = br.readLine().split(" ");


            int idx = 0;

            while(idx < instruct.length){

                if(instruct[idx].equals("I")){
                    idx = insert(instruct,idx);
                }
                else if(instruct[idx].equals("D")){
                    idx = delete(instruct, idx);
                }

            }

            System.out.print("#"+test+ " ");

            for(int i = 0; i < 10; i++){
                System.out.print(list.get(i) + " ");
            }

           System.out.println();
        } // test for문



    } //main

    static int delete(String[] instruct, int index){

        int pos = Integer.parseInt(instruct[index+1]);
        int cnt = Integer.parseInt(instruct[index+2]);

        for(int i = 0; i < cnt; i++){
            list.remove(pos);
        }


        return index+3;
    }



    static int insert(String[] instruct, int index){

        int idx = index;


        int x = Integer.parseInt(instruct[idx+1]);
        int y = Integer.parseInt(instruct[idx+2]);

        //System.out.println(idx + " x : " + x + " y : " + y);

        String[] num = new String[y];
        //System.out.println("idx : " + idx);


        for(int i = 0; i < y; i++){
            num[i] = instruct[i+ idx +3];
            //System.out.print(num[i] + " ");
        }

        //System.out.println();

        for(int ind = 0; ind < y; ind++){
            list.add((ind+x), num[ind]);
        }

        idx += (3+y);

        return idx;

    }


}
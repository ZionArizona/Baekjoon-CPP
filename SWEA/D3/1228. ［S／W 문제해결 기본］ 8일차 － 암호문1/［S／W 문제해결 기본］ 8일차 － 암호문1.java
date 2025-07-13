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


            //System.out.println(instruct.length);
            
            insert(instruct);

            

            

            System.out.print("#"+test+ " ");

            for(int i = 0; i < 10; i++){
                System.out.print(list.get(i) + " ");
            }

            System.out.println();
        } // test for문



    } //main
    
    static void insert(String[] instruct){

        int idx = 0;
        while(idx < instruct.length){


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

            for(int index = 0; index < y; index++){
                list.add((index+x), num[index]);
            }

            idx += (3+y);

        }
        
        
    }
    
    
}
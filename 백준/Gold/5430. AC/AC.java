import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++){

            String str = br.readLine();

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            int[] arr = new int[N];

            Deque<Integer> deq = new ArrayDeque<>();

            for(int i = 0; i < N; i++){
                deq.offer(Integer.parseInt(st.nextToken()));
            }

            int idx = 0;
            boolean flag = false;
            boolean check = false;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == 'R'){
                    flag = !flag;
                }
                else{
                    if(deq.isEmpty()){
                        check = true;
                        break;
                    }else{
                        if(flag == false){
                            deq.poll();
                        }
                        else{
                            deq.pollLast();
                        }
                    }
                }
            }

            if(check == true){
                sb.append("error\n");
            }
            else{
                String ans = "[";
                sb.append("[");
                while(!deq.isEmpty()){

                    sb.append(flag?deq.pollLast() : deq.poll());

                    if(!deq.isEmpty()){
                        sb.append(",");
                    }

                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    } //main
}
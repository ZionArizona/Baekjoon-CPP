import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = 0;

        while((input = Integer.parseInt(br.readLine())) != -1){
            int count = 0;
            List<Integer> div = new ArrayList<>();

            int sum = 0;

            for(int i = 1; i <= Math.sqrt(input); i++){
                if(input % i == 0){
                    div.add(i);
                    sum += i;

                    if(i != 1 && i != input/i){
                        div.add(input/i);
                        sum += input/i;
                    }

                }
            }
            String str = "";
            if(sum == input){
                Collections.sort(div);
                str += (input + " = ");
                for(int i = 0; i < div.size(); i++){
                    str += div.get(i);
                    if (i < div.size() - 1) {
                        str += " + ";
                    }
                }
                System.out.println(str);
            }
            else{
                System.out.println(input + " is NOT perfect.");
            }

        }



    }
}

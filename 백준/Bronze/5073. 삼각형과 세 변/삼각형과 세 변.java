import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            String[] str = br.readLine().split(" ");
            Arrays.sort(str,(a,b) -> Integer.compare(Integer.parseInt(b), Integer.parseInt(a)));
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);


            if(a == 0 && b == 0 && c== 0){
                break;
            }
            if(a >= b + c){
                System.out.println("Invalid");
            }
            else if(a == b && b ==c){
                System.out.println("Equilateral");
            }
            else if((a == b && b != c) || (a == c && b !=c) ||(b== c && a != b)){
                System.out.println("Isosceles");
            }
            else{
                System.out.println("Scalene");
            }


        }
    }
}

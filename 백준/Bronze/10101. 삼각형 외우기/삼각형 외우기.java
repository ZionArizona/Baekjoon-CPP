import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int sum = a + b +c;

        if( a == 60 && b == 60 && c == 60){
            System.out.println("Equilateral");
        }
        else if(sum == 180 && ((a == b && b != c) || (a == c && a != b) || (b == c && a != b))){
            System.out.println("Isosceles");
        }
        else if(sum == 180 && (a != b && b != c && a != c)){
            System.out.println("Scalene");
        }
        else if(sum != 180){
            System.out.println("Error");
        }
    }
}
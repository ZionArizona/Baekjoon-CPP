import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        
        int one = num2%10;
        int two = (num2/10)%10;
        int three = (num2/100);
        
        System.out.println(num1*one);
        System.out.println(num1*two);
        System.out.println(num1*three);
        System.out.println(num1*num2);
        
        
    }
}
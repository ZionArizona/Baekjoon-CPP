import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        String find = br.readLine();

        boolean flag = true;

        for(int i = 0; i < str.length; i++){
            while(find.contains(str[i])){
                find = find.replace(str[i],"#");
            }
        }

        System.out.println(find.length());
        
    }
}

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        int grade_sum = 0;

        for(int i = 0; i < 20; i++){


            String[] str = br.readLine().split(" ");
            double hak = Double.parseDouble(str[1]);
            String grade = str[2];

            if(grade == "P"){
                continue;
            }
            switch(grade){
                case "A+":
                    sum += 4.5 * hak;
                    grade_sum += hak;
                    break;
                case "A0":
                    sum += 4.0 * hak;
                    grade_sum += hak;
                    break;
                case "B+":
                    sum += 3.5 * hak;
                    grade_sum += hak;
                    break;
                case "B0":
                    sum += 3.0 * hak;
                    grade_sum += hak;
                    break;
                case "C+":
                    sum += 2.5 * hak;
                    grade_sum += hak;
                    break;
                case "C0":
                    sum += 2.0 * hak;
                    grade_sum += hak;
                    break;
                case "D+":
                    sum += 1.5 * hak;
                    grade_sum += hak;
                    break;
                case "D0":
                    sum += 1.0 * hak;
                    grade_sum += hak;
                    break;
                case "F":
                    sum += 0.0 * hak;
                    grade_sum += hak;
                    break;
            }
        }
        System.out.println(sum/grade_sum);
    }
}

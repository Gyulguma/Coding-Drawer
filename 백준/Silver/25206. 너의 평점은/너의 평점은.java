import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        float totalScore = 0;
        float totalClass = 0;
        for(int i=0; i<20; i++){
            String line = scanner.nextLine();
            String[] input = line.split(" ");
            float cls = Float.parseFloat(input[1]);
            switch (input[2]){
                case "A+":  totalClass += cls;
                            totalScore += cls*4.5;
                            break;
                case "A0":  totalClass += cls;
                            totalScore += cls*4.0;
                            break;
                case "B+":  totalClass += cls;
                            totalScore += cls*3.5;
                            break;
                case "B0":  totalClass += cls;
                            totalScore += cls*3.0;
                            break;
                case "C+":  totalClass += cls;
                            totalScore += cls*2.5;
                            break;
                case "C0":  totalClass += cls;
                            totalScore += cls*2.0;
                            break;
                case "D+":  totalClass += cls;
                            totalScore += cls*1.5;
                            break;
                case "D0":  totalClass += cls;
                            totalScore += cls*1.0;
                            break;
                case "F":  totalClass += cls;
                            totalScore += cls*0.0;
                            break;
            }
        }
        float result = totalScore/totalClass;
        System.out.println(result);
    }
}

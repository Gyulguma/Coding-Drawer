import java.util.Scanner;

public class Main {

    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        long result = 0;
        String[] inputs = scanner.nextLine().split(" ");
        for(int i=0; i<inputs.length; i++){
            result += Long.parseLong(inputs[i]);
        }
        System.out.println(result);
        scanner.close();
    }
}
import java.util.Scanner;

public class Main {

    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        int count = Integer.parseInt(scanner.nextLine());
        String[] inputs = scanner.nextLine().split(" ");
        String v = scanner.nextLine();
        for(int i=0; i<count; i++){
            if(v.equals(inputs[i])) result++;
        }
        System.out.println(result);
    }
}

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int number = scanner.nextInt()-1;
        System.out.println(word.charAt(number));
        scanner.close();
    }
}

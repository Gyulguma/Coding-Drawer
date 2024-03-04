import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        for(int i=0; i<repeat; i++){
            String word = scanner.next();
            System.out.println(word.charAt(0)+""+word.charAt(word.length()-1));
        }
        scanner.close();
    }
}

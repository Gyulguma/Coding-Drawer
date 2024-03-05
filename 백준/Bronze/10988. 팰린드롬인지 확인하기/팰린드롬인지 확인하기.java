import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        scanner.close();
        int result = 1;
        for(int i=0, j=word.length()-1; i<j; i++,j--){
            if(word.charAt(i) != word.charAt(j)){
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }
}

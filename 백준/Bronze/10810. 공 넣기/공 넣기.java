import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String result = "int";
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] basket = new int[count];
        int repeat = scanner.nextInt();
        for(int b = 0; b<repeat; b++){
            int start = scanner.nextInt()-1;
            int end = scanner.nextInt();
            int number = scanner.nextInt();
            for(; start<end; start++){
                basket[start] = number;
            }
        }
        for(int i=0; i<basket.length;i++){
            System.out.print(basket[i]+" ");
        }
        scanner.close();
    }
}

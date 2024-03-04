import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] basket = new int[count];
        for(int i=0; i<count; i++){
            basket[i] = i+1;
        }
        int repeat = scanner.nextInt();
        for(int b=0;b<repeat; b++){
            int start = scanner.nextInt()-1;
            int end = scanner.nextInt()-1;
            for(int i=start, j=end; i<j; i++, j--){
                int temp = basket[j];
                basket[j] = basket[i];
                basket[i] = temp;
            }
        }
        for(int i=0; i<basket.length; i++){
            System.out.print(basket[i]+" ");
        }
        scanner.close();
    }
}

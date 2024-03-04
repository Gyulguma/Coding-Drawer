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
            int target1 = scanner.nextInt()-1;
            int target2 = scanner.nextInt()-1;
            int temp = basket[target2];
            basket[target2] = basket[target1];
            basket[target1] = temp;
        }
        for(int i=0; i<basket.length; i++){
            System.out.print(basket[i]+" ");
        }
        scanner.close();
    }
}

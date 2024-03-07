import java.util.Scanner;

public class Main {

    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int column=0, row=0;
        for(int i=0; i<9; i++){
            String[] numbers = scanner.nextLine().split(" ");
            for(int j=0; j<9; j++){
                int temp = Integer.parseInt(numbers[j]);
                if(temp >= max){
                    max = temp;
                    column = j+1;
                    row = i+1;
                }
            }
        }
        System.out.println(max+"\n"+row+" "+column);
        scanner.close();
    }
}
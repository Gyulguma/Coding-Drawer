import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] infos = input.split(" ");
        int row = Integer.parseInt(infos[0]);
        int column = Integer.parseInt(infos[1]);
        int[][] table = new int[column][row];
        for(int i=0; i<row; i++){
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            for(int j=0;j<column;j++){
                table[j][i] = Integer.parseInt(numbers[j]);
            }
        }
        for(int i=0; i<row; i++){
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            for(int j=0;j<column;j++){
                table[j][i] += Integer.parseInt(numbers[j]);
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                System.out.print(table[j][i]+" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

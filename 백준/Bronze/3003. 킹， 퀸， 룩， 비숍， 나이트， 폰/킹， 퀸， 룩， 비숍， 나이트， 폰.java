import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] need = {1,1,2,2,2,8};
        String input = scanner.nextLine();
        String[] have = input.split(" ");
        for(int i=0; i<6; i++){
            need[i] -= Integer.parseInt(have[i]);
        }
        for(int i: need){
            System.out.print(i+" ");
        }
    }
}

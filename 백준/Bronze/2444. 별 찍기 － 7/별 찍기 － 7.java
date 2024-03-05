import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<number; i++){
            for(int j=i; j<number-1; j++){
                sb.append(" ");
            }
            for(int k=0; k<i*2+1; k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=number-1; i>0;i--){
            for(int j=i; j<number; j++){
                sb.append(" ");
            }
            for(int k=0; k<(i-1)*2+1; k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

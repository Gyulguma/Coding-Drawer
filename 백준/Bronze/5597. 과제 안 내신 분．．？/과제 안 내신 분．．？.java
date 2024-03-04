import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean[] student = new boolean[31];
        for(int b=0;b<28; b++){
            int number = scanner.nextInt();
            student[number] = true;
        }
        for(int i=1; i<student.length; i++){
            if(student[i] == false)
                System.out.println(i);
        }
        scanner.close();
    }
}

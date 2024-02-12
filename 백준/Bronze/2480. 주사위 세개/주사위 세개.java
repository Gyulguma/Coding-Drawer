import java.util.Scanner;

public class Main {

    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        String[] inputs = scanner.nextLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);

        if(a == b & b == c) result = 10000 + a*1000;
        else if(a == b & a != c) result = 1000 + a*100;
        else if(b == c & b != a) result = 1000 + b*100;
        else if(c == a & a != b) result = 1000 + c*100;
        else {
            int max = Math.max(a, b);
            max = Math.max(max, c);
            result = max*100;
        }
        System.out.println(result);
    }
}
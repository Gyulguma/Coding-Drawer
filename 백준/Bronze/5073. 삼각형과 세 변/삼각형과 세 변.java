import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        while(!line.equals("0 0 0")){
            String[] numbers = line.split(" ");
            Arrays.sort(numbers, (o1, o2) -> {
                return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
            });
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            int c = Integer.parseInt(numbers[2]);

            if(c >= a+b) System.out.println("Invalid");
            else if(a==b && b==c) System.out.println("Equilateral");
            else if((a==b && b!=c) || (a==c && b!=c) || (c==b && b!=a)) System.out.println("Isosceles");
            else if(a!=b && b!=c && a!=c) System.out.println("Scalene");

            line = sc.nextLine();
        }
        sc.close();
    }
}
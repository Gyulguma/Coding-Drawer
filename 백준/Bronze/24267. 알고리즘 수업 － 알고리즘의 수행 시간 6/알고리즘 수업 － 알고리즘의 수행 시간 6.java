import java.util.*;

public class Main {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(n*(n-1)*(n-2)/6 + "\n" + 3);
        sc.close();
    }
}
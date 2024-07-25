import java.util.*;

public class Main {
    static int a1 = 0;
    static int a2 = 0;
    static int c = 0;
    static int n0 = 0;

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        a1 = sc.nextInt();
        a2 = sc.nextInt();
        c = sc.nextInt();
        n0 = sc.nextInt();

        if(a1-c < 0 && f(n0) <= 0)
            System.out.println(1);
        else if(a1==c && a2 <=0)
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static int f(int n){
        return (a1-c)*n + a2;
    }
}
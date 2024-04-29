import java.util.*;
import java.lang.Math;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int result = 0;
        result = Math.min(x-0, y-0);
        result = Math.min(result, w-x);
        result = Math.min(result, h-y);
        System.out.println(result);
        sc.close();
    }
}
import java.util.*;
import java.lang.Math;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger b = new BigInteger(sc.next());
        System.out.println(b.multiply(b).multiply(b).toString() + "\n" + 3);
        sc.close();
    }
}
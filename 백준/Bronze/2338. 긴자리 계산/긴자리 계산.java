import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        
        BigInteger plus = a.add(b);
        BigInteger minus = a.subtract(b);
        BigInteger multi = a.multiply(b);
        
        System.out.println(plus);
        System.out.println(minus);
        System.out.println(multi);
    }
}
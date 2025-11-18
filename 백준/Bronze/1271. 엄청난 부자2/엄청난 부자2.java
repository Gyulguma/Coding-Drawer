import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        BigInteger[] c = a.divideAndRemainder(b);
        System.out.println(c[0]+" "+c[1]);
    }
}
import java.util.*;
import java.io.*;

public class Main{
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        long result = pow(a, b, c);
        System.out.println(result);
    }
    
    private static long pow(int base, int exp, int mod) {
    	if(exp == 0) return 1;
    	
    	long temp = pow(base, exp/2, mod);
    	
    	if(exp%2 == 0) return temp * temp % mod;
    	return (temp * temp % mod) * base % mod;
    }
}
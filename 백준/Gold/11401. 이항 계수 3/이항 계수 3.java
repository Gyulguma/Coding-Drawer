import java.util.*;
import java.io.*;

public class Main{
	private static final int P = 1000000007;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        long numerator = factorial(n);
        
        long denominator = factorial(k) * factorial(n-k) % P;
        
        long result = numerator * pow(denominator, P-2) % P;
        System.out.println(result);
    }
    
    private static long factorial(long n) {
    	long result = 1L;
    	for(long i=1; i<=n; i++) {
    		result = (result * i) %P;
    	}
    	return result;
    }
    
    private static long pow(long base, long expo) {
    	if(expo == 1) return base % P;
    	
    	long temp = pow(base, expo/2);
    	
    	if(expo%2 == 0) return temp * temp % P;
    	return (temp * temp % P) * base % P;
    }
}
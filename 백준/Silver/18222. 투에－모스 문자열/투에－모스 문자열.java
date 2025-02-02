import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());
		
		boolean flag = false;
		
		while(k > 1) {
			long pow = 1;
			while(pow < k) {
				pow *= 2;
			}
			k -= pow/2;
			
			flag = !flag;
		}
		
		int result = flag ? 1 : 0;
		
		System.out.println(result);
	}
}
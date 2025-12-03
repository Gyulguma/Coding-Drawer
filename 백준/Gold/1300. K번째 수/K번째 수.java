import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        long left = 1;
        long right = k;
        
        long result = 0;
        while(left <= right) {
        	long mid = left + (right-left)/2;
        	
        	long count = count(n, mid);
        	
        	if(count < k) {
        		left = mid+1;
        		continue;
        	}
        	result = mid;
        	right = mid-1;
        }
        System.out.println(result);
    }

	private static long count(int n, long mid) {
		long count = 0;
		for(int i=1; i<=n; i++) {
			count += Math.min(mid/i, n);
		}
		return count;
	}
    
}

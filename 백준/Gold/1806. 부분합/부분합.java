import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = nums[0];
        int left = 0;
        int right = 0;
        
        int min = Integer.MAX_VALUE;
        while(true) {
        	if(sum >= s && left <= right) {
        		min = Math.min(min, (right-left+1));
        		sum -= nums[left]; 
        		left++;
        		continue;
        	}
        	right++;
        	if(right >= n) break;
        	sum += nums[right];
        	
        }
        if(min == Integer.MAX_VALUE) min = 0;
        System.out.println(min);
    }
    
}

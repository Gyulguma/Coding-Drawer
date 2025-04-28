import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] number = new int[n];
        for(int i=0; i<n; i++) {
        	number[i] = Integer.parseInt(br.readLine());
        }
        
        int[] count = new int[h];
        for(int i=0; i<n; i+=2) {
        	count[0]++;
        	count[number[i]]--;
        }
        
        for(int i=1; i<n; i+=2) {
        	count[h-number[i]]++;
        }
        
        int[] sum = new int[h];
        sum[0] = count[0];
        for(int i=1; i<h; i++) {
        	sum[i] = sum[i-1]+count[i];
        }
        
        Arrays.sort(sum);
        int result = 1;
        for(int i=1; i<h; i++) {
        	if(sum[0] != sum[i]) break;
        	result++;
        }
        
        System.out.println(sum[0]+" "+result);
    }
}

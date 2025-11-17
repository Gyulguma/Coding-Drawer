import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] points = new int[n+1][2];
        
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	points[i][0] = Integer.parseInt(st.nextToken());
        	points[i][1] = Integer.parseInt(st.nextToken());        	
        }
        
        points[n][0] = points[0][0];
        points[n][1] = points[0][1];
        
        double sum = 0;
        for(int i=0; i<n; i++) {
        	sum += ((double)points[i][0] * points[i+1][1]) - ((double)points[i][1] * points[i+1][0]);
        }
        
        System.out.printf("%.1f", Math.abs(sum/2));
    }
    
}

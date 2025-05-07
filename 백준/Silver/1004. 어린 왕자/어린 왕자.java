import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int repeat = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int re=0; re<repeat; re++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        	int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        	
        	int n = Integer.parseInt(br.readLine());
        	int count = 0;
        	for(int i=0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		int r = Integer.parseInt(st.nextToken());
        		
        		double startD = Math.sqrt(Math.pow(Math.abs(start[0]-x), 2) + Math.pow(Math.abs(start[1]-y), 2));
        		double endD = Math.sqrt(Math.pow(Math.abs(end[0]-x), 2) + Math.pow(Math.abs(end[1]-y), 2));
        		
        		if(r < startD && r < endD) continue;
        		if(r < startD || r < endD) count++;
        	}
        	
        	sb.append(count).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}

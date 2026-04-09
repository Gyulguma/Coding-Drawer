import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] infos = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			infos[i][0] = Integer.parseInt(st.nextToken());
			infos[i][1] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int count = 1;
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				if(infos[i][0] >= infos[j][0] || infos[i][1] >= infos[j][1]) continue;
				count++;
			}
			sb.append(count).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
	
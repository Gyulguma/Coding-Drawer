import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		if(2*w <= s) {
			System.out.println(w*(x+y));
			return;
		}
		
		long big = Math.max(x, y);
		long small = Math.min(x, y);
		
		long result = s * small;
		
		long quotient = (big-small)/2;
		long remaind = (big-small)%2;
		if(w > s) {
			result += quotient*s*2 + remaind*w;
			
		}
		else result += (big-small)*w;
		
		System.out.println(result);
	}
}

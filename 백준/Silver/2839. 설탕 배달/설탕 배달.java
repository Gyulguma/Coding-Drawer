import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		for(int i=n/5; i>=0; i--) {
			int left = n-(5*i);
			if(left%3 != 0) continue;
			min = Math.min(min, i+left/3);
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
}

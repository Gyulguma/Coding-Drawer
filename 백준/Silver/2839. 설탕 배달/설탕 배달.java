import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(leastCount(n));
	}

	private static int leastCount(int n) {
		if(n%5 == 0) {
			return n/5;
		}else {
			int min = -1;
			for(int i=0; i*5 <= n;i++) {
				if((n-(i*5))%3 == 0) {
					if(min == -1) {
						min = i+(n-(i*5))/3;
					}else {
						min = Math.min(min, i+(n-(i*5))/3);	
					}
				}
			}
			return min;
		}
		
	}


}
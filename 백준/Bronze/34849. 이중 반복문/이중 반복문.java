import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		if(num <= 10000) System.out.println("Accepted");
		else System.out.println("Time limit exceeded");

	}
}
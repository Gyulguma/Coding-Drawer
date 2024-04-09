import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int result = (int)(Math.pow(2, n) + 1);
			System.out.println(result*result);
			br.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}

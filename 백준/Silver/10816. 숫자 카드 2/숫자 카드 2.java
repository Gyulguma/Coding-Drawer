import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] arg) throws IOException {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<>();
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			int number = sc.nextInt();
			map.put(number, map.getOrDefault(number,0)+1);
		}
		StringBuilder sb = new StringBuilder();
		int m = sc.nextInt();
		for(int i=0; i<m; i++){
			int number = sc.nextInt();
			sb.append(map.getOrDefault(number,0)+" ");
		}
		System.out.println(sb.toString());
	}
}

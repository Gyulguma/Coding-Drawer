import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=m; i<=n; i++){
			if(i==1 || i==2) {
				sb.append(2).append("\n");
				i=2;
				continue;
			}
			if(check(i)){
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString().trim());
	}

	private static boolean check(int number) {
		for(int i=2; i<=Math.sqrt(number); i++){
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}
}
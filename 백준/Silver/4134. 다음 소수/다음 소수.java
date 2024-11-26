import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < repeat; i++) {
			long number = Long.parseLong(br.readLine());
			if(number == 0 || number == 1) {
				sb.append(2).append("\n");
				continue;
			}
			long result = findNumber(number);
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString().trim());
	}

	private static long findNumber(long number) {
		long result = number;
		while(true){
			if(check(result)){
				return result;
			}
			result++;
		}
	}

	private static boolean check(long result) {
		if(result == 2) return true;
		double sqrt = Math.sqrt(result);
		for(long i = 2; i<=sqrt; i++){
			if(result%i == 0) return false;
		}
		return true;
	}
}
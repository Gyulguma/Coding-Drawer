import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n == 1) {
			System.out.println(0);
			return;
		}
		List<Integer> list = new ArrayList<>();
		
		To: for(int i=2; i<=n; i++) {
			if(i==2) {
				list.add(2);
				continue;
			}
			if(i%2 == 0) continue;
			
			if(isRight(i)) list.add(i);
		}
		
		int left = 0;
		int right = 1;
		int sum = list.get(left);
		
		int result = 0;
		while(right < list.size() && left <= right) {
			if(sum < n) {
				sum += list.get(right++);
				continue;
			}
			if(sum > n) {
				sum -= list.get(left++);
				continue;
			}
			
			result++;
			sum += list.get(right++);
		}
		
		if(list.get(list.size()-1) == n) result++;
		System.out.println(result);
		
	}
	
	private static boolean isRight(int num) {
		for(int i=3; i<=Math.sqrt(num); i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}

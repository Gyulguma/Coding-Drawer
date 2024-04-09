import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int target = sc.nextInt();
		int count = 0, result = 0;
		for(int i=1; i<=number; i++){
			if(count == target) break;
			if(number % i == 0){
				result = i;
				count++;
			}
		}
		if(count != target)
			System.out.println(0);
		else
			System.out.println(result);
	}
}

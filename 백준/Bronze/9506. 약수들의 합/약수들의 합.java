import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total =0;
		String result = "";
		int number = sc.nextInt();
		List<Integer> factors = new ArrayList<>();
		while(number != -1){
			for(int i=1; i<number; i++){
				if(number % i == 0){
					factors.add(i);
					total += i;
				}
				if(total > number) break;
			}
			if(total == number){
				result = number + " = ";
				for(int i=0; i<factors.size(); i++){
					result += factors.get(i);
					if(i != factors.size()-1)
						result += " + ";
				}
			}
			else
				result = number + " is NOT perfect.";
			System.out.println(result);
			total = 0;
			factors.clear();
			number = sc.nextInt();
		}
	}
}

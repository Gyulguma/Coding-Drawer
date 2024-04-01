import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int input =sc.nextInt();
		int formation = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(input >= formation){
			int temp = input%formation;
			if(temp >= 10){
				char a = (char)(temp + 55);
				sb.append(a);
			}
			else{
				sb.append(temp);
			}
			input = input/formation;
		}
		if(input >= 10)
			sb.append((char)(input + 55));
		else
			sb.append(input);
		sb.reverse();
		String result = sb.toString();
		System.out.println(result);
		sc.close();
	}
}

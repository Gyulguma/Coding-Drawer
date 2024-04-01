import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<repeat; i++){
			int money = sc.nextInt();
			sb.append(money/25);
			money = money%25;
			sb.append(" "+money/10);
			money = money%10;
			sb.append(" "+money/5);
			money = money%5;
			sb.append(" "+money+"\n");
		}
		System.out.println(sb);
	}
}

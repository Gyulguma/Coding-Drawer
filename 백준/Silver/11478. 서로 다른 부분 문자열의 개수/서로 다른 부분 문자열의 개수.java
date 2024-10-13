import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet<>();
		String word = sc.next();
		recursion(word, set, 0);
		System.out.println(set.size());
	}

	private static void recursion(String word, Set<String> set, int index) {
		if(index >= word.length()) return;
		String temp = "";
		for(int i=index; i<word.length(); i++){
			temp += word.charAt(i)+"";
			set.add(temp);
		}
		recursion(word, set, index+1);
	}
}

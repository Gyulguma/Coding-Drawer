
import java.io.*;

public class Main {


	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] input = new String[5][15];
		for(int i=0; i<5; i++){
			try {
				String word = br.readLine();
				for(int j=0; j<word.length(); j++){
					input[i][j] = word.charAt(j)+"";
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<input[0].length;i++){
			for(int j=0; j<input.length; j++){
				if(input[j][i] != null)  sb.append(input[j][i]+"");
			}
		}
		System.out.println(sb);
	}
}

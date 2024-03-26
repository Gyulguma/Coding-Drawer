import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[][] paper = new int[100][100];
		int count = sc.nextInt();
		for(int i=0; i<count; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j=0; j<10; j++){
				for(int k=0; k<10; k++){
					paper[x+j][y+k] = 1;
				}
			}
		}
		int black = 0;
		for(int i=0; i<100; i++){
			for(int j=0; j<100; j++){
				if(paper[i][j] == 1) black++;
			}
		}
		System.out.println(black);
	}
}

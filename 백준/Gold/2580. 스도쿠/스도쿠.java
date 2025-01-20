import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static int[][] board;
	private static List<int[]> targets;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[9][9];
		targets = new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<9; j++) {
				board[i][j] = Integer.parseInt(line[j]);
				if(board[i][j] == 0) {
					targets.add(new int[]{i, j});
				}
			}
		}
		
		backTracking(0, targets.size());
		
		printBoard();
	}

	private static boolean backTracking(int index, int size) {
        if(index == size) {
            return true;
        }
        
        int[] target = targets.get(index);
        int row = target[0];
        int col = target[1];
        
        for(int value=1; value<=9; value++) {
            if(canSet(row, col, value)) {
                board[row][col] = value;
                if(backTracking(index+1, size)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

	private static boolean canSet(int row, int col, int value) {
		for(int i=0; i<9; i++) {
			if(board[row][i] == value) {
				return false;
			}
			if(board[i][col] == value) {
				return false;
			}
		}
		int sectionRow = row/3*3;
		int sectionCol = col/3*3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[sectionRow+i][sectionCol+j] == value) {
					return false;
				}
			}
		}
		return true;
	}

	private static void printBoard() {
		StringBuilder resultSb = new StringBuilder();
		for(int i=0; i<9; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<9; j++) {
				sb.append(board[i][j]).append(" ");
			}
			resultSb.append(sb.toString().trim());
			resultSb.append("\n");
		}
		System.out.println(resultSb.toString().trim());
	}

}

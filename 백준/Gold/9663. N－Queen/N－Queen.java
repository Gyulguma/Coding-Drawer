import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static int[] board;
    private static int count=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n];

        backTracking(n, 0);

        System.out.println(count);
    }

    private static void backTracking(int n, int row) {
        if(row == n){
            count++;
            return;
        }

        for(int col=0; col<n; col++){
            if(!canPut(row, col)) continue;
            board[row] = col;
            backTracking(n, row+1);
            board[row] = 0;
        }
    }

    private static boolean canPut(int row, int col) {
        for(int i=0; i<row; i++){
            if(board[i] == col) return false;
            if(Math.abs(row-i) == Math.abs(col-board[i])) return false;
        }
        return true;
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper; // 종이 내 숫자 구별

    static int minusOne, zero, one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //영상의 크기

        paper = new int[N][N]; //영상 데이터 구성

        for(int i = 0; i < N; i++){ //종이 내부 숫자 입력받기
            st = new StringTokenizer(br.readLine()); //한줄 식 입력받기

            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken()); //띄어쓰기로 쪼개서 입력받기
            }
        }

        br.close();

        cutPaper(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    static void cutPaper(int row, int col, int size){

        if(chkPaper(row, col, size)){ //분할한 종이의 내부 숫자들이 모두 같은 숫자이면
            if(paper[row][col] == -1){  // 그 숫자가 -1이면
                minusOne++;
            }else if(paper[row][col] == 0){ // 그 숫자가 0이면
                zero++;
            }else if(paper[row][col] == 1){ // 그 숫자가 1이면
                one++;
            }
        }else { //분할한 숫자가 모두 같은 숫자로만 이루어져 있지 않을 때
            int newSize = size / 3; //전체 종이 사이즈를 9분할로 해야하기 때문에 3x3으로 하므로 사이즈 3

            for (int x = 0; x < size; x += newSize) { //분할한 사이즈만큼 증가시켜서 9분할
                for (int y = 0; y < size; y += newSize) {
                    cutPaper(row + x, col + y, newSize);
                }
            }
        }
    }

    //종이의 내부 숫자가 같은 숫자로만 이루어졌는지 비교
    static boolean chkPaper(int row, int col, int size){
        int data = paper[row][col]; //맨 처음 값으로 비교

        for(int i = row; i < row+size; i++){
            for(int j = col; j < col+size; j++){
                if(paper[i][j] != data){
                    return false;
                }
            }
        }
        
        return true;
    }
}
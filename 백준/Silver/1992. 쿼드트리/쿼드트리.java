import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] video; //정사각형 색종이 색 구별(1과 0으로)
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //영상의 크기

        video = new int[N][N]; //영상 데이터 구성

        for(int i = 0; i < N; i++){ //영상 구성 데이터 입력받기
            String str = br.readLine(); //한줄이 숫자 하나로 받기 때문에 (띄어쓰기가 없음)

            for(int j = 0; j < N; j++){
                // char :  단 한 글자만 저장할 수 있는 변수 한글자만을 빼야하기 때문
                // '0'의 아스키코드값은 48로 0이 나오면 48 -48 = 0 이 저장
                // '1'의 아스키코드값은 49로 1이 나오면 49 - 48 = 1이 저장
                video[i][j] = str.charAt(j) - '0'; //문자를 '0'으로 빼서 0 혹은 1만 나오게 함
            }
        }

        br.close();

        cutVideo(0, 0, N);

        System.out.println(sb);
    }

    static void cutVideo(int row, int col, int size){//영상 분할(0으로만, 1로만 이루어지도록)

        if(chkVideo(row, col, size)){  //만약
           sb.append(video[row][col]);
           return;
        }

        //4개로 줄이기 위해
        int mSize = size/2; //절반 사이즈 (left+right)/2와 같은 역할을 함 (압축이 불가능 하므로)

        //분할할때마다의 깊이 시작 부분에 괄호 끝부분에 괄호해서 묶어줌
        sb.append('(');
        cutVideo(row, col, mSize);                      // 출력 순서 1
        cutVideo(row, col+mSize, mSize);            // 출력 순서 2
        cutVideo(row+mSize, col, mSize);           //  출력 순서 3
        cutVideo(row+mSize, col+mSize, mSize); // 출력 순서 4
        sb.append(')');
    }

    static boolean chkVideo(int row, int col, int size){ //영상 데이터 확인
        int data = video[row][col]; // (row, col)을 기준으로 data 확인

        for(int i = row; i < row+size; i++){
            for(int j = col; j < col+size; j++){
                if(video[i][j] != data){ //처음 기준 data와 다르면
                    return false;
                }
            }
        }
        
        return true; //모두 같은 data이면
    }
}
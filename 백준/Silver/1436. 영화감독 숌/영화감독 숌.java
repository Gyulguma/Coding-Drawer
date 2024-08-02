import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //입력받은 N번째
        br.close();

        int movieName = 666; //영화 제목이 들어갈 변수
        int count = 1; //반복문 카운트 셀 변수

        while(N > count){
            movieName++;

            if(String.valueOf(movieName).contains("666")){ //666이 들어간 부분을 순서대로
                //만약  666을 포함한다면
                count++;
            }
        }

        bw.write(movieName+"");
        bw.flush();
        bw.close();

    }
}
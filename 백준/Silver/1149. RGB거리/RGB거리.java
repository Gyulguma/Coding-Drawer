import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] homeColor;

    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        homeColor = new int[N][3];

        StringTokenizer st;

        for(int i = 0; i < N; i++){ //배열 초기회
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                homeColor[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        
        //최솟값 찾기 (1부터 N-1인 이유는 0번째는 어차피 그 비용이기도 하고, N-1은 배열은 0인덱스이기 때문)
        for(int i = 1; i < N; i++){ //서로 다른 색(직전의)의 비용의 최솟값을 누적더하기
            homeColor[i][0] += Math.min(homeColor[i-1][1], homeColor[i-1][2]);
            homeColor[i][1] += Math.min(homeColor[i-1][0], homeColor[i-1][2]);
            homeColor[i][2] += Math.min(homeColor[i-1][1], homeColor[i-1][0]);
        }

        System.out.println(Math.min(homeColor[N-1][0], Math.min(homeColor[N-1][1], homeColor[N-1][2])));
    }
}
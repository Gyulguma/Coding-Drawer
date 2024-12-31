import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[][][] result = new int[21][21][21]; //a, b, c가 20이 최대이기 때문에 21(인덱스 0부터 시작)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); //a 값
        int b = Integer.parseInt(st.nextToken()); //b 값
        int c = Integer.parseInt(st.nextToken()); //c 값

        while (!(a == -1 && b == -1 && c == -1)) {

            sb.append("w(" + a + ", " + b + ", " + c + ") = ");
            sb.append(solution(a, b, c)).append("\n");

            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken()); //a 값
            b = Integer.parseInt(st.nextToken()); //b 값
            c = Integer.parseInt(st.nextToken()); //c 값

        }

        System.out.println(sb);


        br.close();
    }

    //w(a, b, c)값을찾는 메소드
    static int solution(int a, int b, int c) {

        //범위 내 값에 있으면서 이미 값을 가진 배열 인덱스일 경우(=>빠르게 값을 받아옴(미리 저장))
        if (validCheck(a, b, c) && result[a][b][c] != 0) {
            return result[a][b][c];
        } else if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return result[20][20][20] = solution(20, 20, 20);
        } else if (a < b && b < c) {
            return result[a][b][c] = solution(a, b, c - 1) + solution(a, b - 1, c - 1) - solution(a, b - 1, c);
        }
        return result[a][b][c] = solution(a - 1, b, c) + solution(a - 1, b - 1, c) + solution(a - 1, b, c - 1) - solution(a - 1, b - 1, c - 1);

    }

    //배열 범위 내의 값인지 유효성 검사하는 메소드
    static boolean validCheck(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
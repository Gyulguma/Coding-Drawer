import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //주어진 수의 개수(N)
        int K = Integer.parseInt(st.nextToken()); //연속 일(K)

        number = new int[N];

        st = new StringTokenizer(br.readLine()); //숫자들 입력 받기

        for(int i = 0; i < N; i++){ //배열에 숫자들 하나씩 넣기
            number[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE; //최댓값이 -(음수)가 나올 수도 있기 때문에

        //N-K+1만큼의 반복문(시작이 1일때 기준)이 돌아야 하기 때문에 인덱스가 0일때는 N-K만큼만 돌면 됨!
        for(int i = 0; i <= N-K; i++){
            int sum = 0;
            for(int j = i; j < i+K; j++){ //시작점의 위치와 종료점의 위치가 +1만큼 계속 이동하므로 i증가값에 맞춰 반복!
                sum += number[j];
            }
            max = Math.max(sum, max); //최댓값을 계속 갱신
        }

        System.out.println(max);

       br.close();
    }
}
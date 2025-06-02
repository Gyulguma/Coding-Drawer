import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //사람 수
        
        // 각 사람마다 선택할 수 있는 경우의 수를 계산하여 최댓값 저장하기
		int[] num = new int[5];
        int[] result = new int[n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                num[j] = Integer.parseInt(st.nextToken()); //카드 번호
            }

            int sum = 0;
            for(int a = 0; a < 3; a++){
                for(int b = a+1; b < 4; b++){
                    for(int c = b+1; c < 5; c++){
                        sum = Math.max(sum, (num[a] + num[b] + num[c]) % 10);
                    }
                }
            }

            result[i] = sum;
        }

		// 일의 자리 수가 가장 큰 사람의 번호 출력하기
        int max = result[1];
        int answer = 1;
        for(int i = 2; i < result.length; i++){
            if(max <= result[i]){
                max = result[i];
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
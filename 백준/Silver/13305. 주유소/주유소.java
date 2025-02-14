import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //도시의 개수

        int[] oil = new int[N-1]; //도시->다른 도시로 필요한 기름의 양
        int[] cost = new int[N];  //도시별 기름 값

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < oil.length; i++){ //필요한 기름의 양 입력
           oil[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int prevMin = Integer.MAX_VALUE; //전인덱스 기준으로 최솟값 저장하는 변수
        
        for(int i = 0; i < cost.length; i++){ //도시별 기름 값 입력
            int currentValue = Integer.parseInt(st.nextToken());

            if(prevMin > currentValue){ //이전 비용보다 현재 비용이 더 작을 경우 현재 비용으로 갱신
                cost[i] = currentValue;
                prevMin = currentValue;
            }else{ // 같거나 클 경우 
                cost[i] = prevMin; // 이전 비용을 그대로 사용
            }
        }

        br.close();

		// 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수 / 리터당 가격은 1 이상 1,000,000,000 이하의 자연수
        // 최종 비용은 이 두개를 곱해서 구하기 때문애 Integer 범위를 넘기게 된다.
        // => long을 사용하는 이유
        long result = 0; //결과(최소 비용) 

        for(int i = 0; i < N-1; i++){ 
            result += ((long) cost[i] *oil[i]);
        }

        System.out.println(result);

    }
}
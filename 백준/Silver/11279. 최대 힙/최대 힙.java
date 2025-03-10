import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); //연산 개수
        /*
        	우선순위 큐를 사용 
        	Collections.reverseOrder() -> 우선순위가 높은 숫자가 먼저 나옴 : 큰 숫자
        */
        PriorityQueue<Integer> Queue = new PriorityQueue <>(Collections.reverseOrder());

        while(N --> 0){
            int x = Integer.parseInt(br.readLine()); //연산
            if(x == 0){ //0이면 가장 큰 값을 출력하고 배열에서 제거
                if(Queue.isEmpty()){ //배열이 비어있으면 0을 출력
                    sb.append(0).append("\n");
                }else{ //배열이 안비어있으면
                    sb.append(Queue.poll()).append("\n");
                }
            }else{ //0이 아니고, 자연수라면 배열에 x를 추가
                Queue.add(x);
            }
        }
        br.close();
        System.out.println(sb);
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 배열 선언 및 입력값 담아두기
        int[] arr = new int [3];
        while (true) {
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            //2. sort해서 가장 긴 변이 배열에 마지막에 오게
            Arrays.sort(arr);
            // 3. 반복문 종료 조건(0 0 0 일때 입력 끝)
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            // 4. 피타고라스 조건에 맞춰 출력    
            } else if (arr[2] * arr[2] == (arr[0] * arr[0]) + (arr[1] * arr[1])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
        sc.close();
    }
}
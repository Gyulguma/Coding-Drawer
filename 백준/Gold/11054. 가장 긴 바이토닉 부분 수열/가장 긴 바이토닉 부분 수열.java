import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // 왼쪽에서 오른쪽으로 LIS 구하기
        int[] dpLR = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dpLR[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpLR[i] = Math.max(dpLR[j] + 1, dpLR[i]);
                }
            }
        }

        // 오른쪽에서 왼쪽으로 LIS 구하기
        int[] dpRL = new int[n + 1];
        for (int i = n; i > 0; i--) {
            dpRL[i] = 1;
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dpRL[i] = Math.max(dpRL[j] + 1, dpRL[i]);
                }
            }
        }

        // 두 dp 배열의 합의 최대값 찾기
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dpLR[i] + dpRL[i]);
        }

        System.out.println(max - 1); // 해당 원소 중복되므로 -1
        sc.close();
    }
}
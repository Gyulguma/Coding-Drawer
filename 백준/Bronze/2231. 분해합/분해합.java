import java.util.*;

public class Main {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for(int i=n-1; i>0; i--){
            int m = i;
            int temp = i;
            while(temp/10 != 0){
                m += temp%10;
                temp /= 10;
            }
            m += temp;
            if(m == n) {
                result = i;
            }
        }
        System.out.println(result);
    }
}
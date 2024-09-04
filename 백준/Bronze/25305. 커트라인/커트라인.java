import java.util.*;

public class Main {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<repeat; i++){
            list.add(sc.nextInt());
        }
        list.sort(Comparator.reverseOrder());
        System.out.println(list.get(k-1));
    }
}
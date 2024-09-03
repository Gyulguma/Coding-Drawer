import java.util.*;

public class Main {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int total = 0;
        for(int i=0; i<5; i++){
            int number = Integer.parseInt(sc.nextLine());
            list.add(number);
            total += number;
        }
        Collections.sort(list);
        System.out.println(total/5);
        System.out.println(list.get(2));
    }
}

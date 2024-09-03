import java.util.*;

public class Main {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        int target = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<repeat; i++){
            list.add(sc.nextInt());
        }

        int result = 0;
        for(int i=0; i<repeat; i++){
            int total = list.get(i);
            for(int j=i+1; j<repeat; j++){
                total += list.get(j);
                for(int k=j+1; k<repeat; k++){
                    total+= list.get(k);
                    if(total <= target){
                        if(result == 0) result = total;
                        else result = result >= total ? result : total;
                    }
                    total -= list.get(k);
                }
                total -= list.get(j);
            }
        }
        System.out.println(result);
    }
}
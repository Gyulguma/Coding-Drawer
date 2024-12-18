import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        int[] numbers = new int[repeat];
        Map<Integer, Integer> map = new HashMap<>();
        long total = 0;
        for (int i = 0; i < repeat; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[i] = number;
            total += number;
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        long a = Math.round((double) total /repeat);
        Arrays.sort(numbers);
        int b = numbers[repeat/2];
        int cMax = 0;
        for(int number : map.keySet()) {
            int count = map.get(number);
            if(count > cMax){
                cMax = count;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int number : map.keySet()) {
            if(map.get(number) == cMax) list.add(number);
        }
        Collections.sort(list);
        int c = list.size() >= 2 ? list.get(1) : list.get(0);
        int d = numbers[repeat-1] - numbers[0];

        System.out.println(a+"\n"+b+"\n"+c+"\n"+d);
    }
}
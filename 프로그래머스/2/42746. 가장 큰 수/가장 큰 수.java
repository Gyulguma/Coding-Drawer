import java.util.*;
import java.math.BigInteger;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        Arrays.sort(arr, (o1, o2) -> {
            return -Integer.compare(Integer.parseInt(o1+o2), Integer.parseInt(o2+o1));
        });
        
        StringBuilder sb = new StringBuilder();
        for(String st : arr){
            sb.append(st);
        }
        
        String answer = sb.toString();
        BigInteger integer = new BigInteger(answer);
        if(integer.compareTo(new BigInteger("0")) == 0) return "0";
        return answer;
    }
}
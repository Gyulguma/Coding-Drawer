import java.util.*;

class Solution {
    public String solution(String s) {
        int[] numbers = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        return numbers[0] + " "+numbers[numbers.length-1];
    }
}
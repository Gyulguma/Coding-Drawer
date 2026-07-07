import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        for(long i=left; i<=right; i++) {
            long x = i/n;
            long y = i%n;
            list.add((int)Math.max(x, y) + 1);
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
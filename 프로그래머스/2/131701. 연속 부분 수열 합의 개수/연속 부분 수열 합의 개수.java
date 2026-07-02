import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<elements.length; i++) {
            int current = 0;
            for(int j=0; j<elements.length; j++) {
                int idx = i+j >= elements.length ? (i+j)-elements.length : i+j;
                current += elements[idx];
                set.add(current);
            }
        }
        
        return set.size();
    }
}
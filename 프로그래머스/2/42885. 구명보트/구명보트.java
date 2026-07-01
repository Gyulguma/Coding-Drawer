import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int value : people) {
            list.add(value);
        }
        Collections.sort(list, (o1, o2) -> o2-o1);
        
        // System.out.println(list);
        
        int left = 0;
        int right = list.size()-1;
        int current = 0;
        while(left <= right) {
            current += list.get(left++);
            
            if(left <= right && current + list.get(right) <= limit) right--;
            
            answer++;
            current = 0;
        }
        
        return answer;
    }
}
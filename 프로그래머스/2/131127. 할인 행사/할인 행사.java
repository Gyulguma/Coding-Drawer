import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for(int i=0; i<10; i++) {
            if(!map.containsKey(discount[i])) continue;
            map.put(discount[i], map.get(discount[i]) - 1);
        }
        
        boolean flag = false;
        for(String key : map.keySet()) {
            if(map.get(key) <= 0) continue;
            flag = true;
            break;
        }
        if(!flag) answer++;
        flag = false;
        
        int left = 0;
        int right = 10;
        while(right < discount.length) {
            if(map.containsKey(discount[left])) {
                map.put(discount[left], map.get(discount[left]) + 1);
            }
            if(map.containsKey(discount[right])) {
                map.put(discount[right], map.get(discount[right]) - 1);
            }
            left++;
            right++;
            
            for(String key : map.keySet()) {
                if(map.get(key) <= 0) continue;
                flag = true;
                break;
            }
            if(!flag) answer++;
            flag = false;
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        int idx = 1;
        for(int i='A'; i<='Z'; i++) {
            map.put((char)i + "", idx++);
        }
        
        char[] charArray = msg.toCharArray();
        int i=0; int j=0;
        while(i < charArray.length) {
            String current = "";
            
            while(j < charArray.length && map.containsKey(current + charArray[j])) {
                current += charArray[j++];
            }
            int number = map.get(current);
            list.add(number);
            
            if(j < charArray.length) {
                map.put(current+charArray[j], idx++);
            }
            i=j;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
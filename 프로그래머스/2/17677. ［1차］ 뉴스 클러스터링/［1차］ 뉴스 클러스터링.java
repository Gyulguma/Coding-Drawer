import java.util.*;

class Solution {
    private static final int NUM = 65536;
    
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = createMap(str1);
        Map<String, Integer> map2 = createMap(str2);
        
        // 교집합 개수
        int g = 0;
        for(String key : map2.keySet()) {
            if(map1.get(key) == null) continue;
            g += Math.min(map1.get(key), map2.get(key));
        }
        
        // 합집합 개수
        int h = 0;
        for(String key : map2.keySet()) {
            map1.put(key, Math.max(map1.getOrDefault(key, 0), map2.get(key)));
        }
        for(String key : map1.keySet()) {
            h += map1.get(key);
        }
        
        
        if(h == 0) return NUM;
        return (int)(((double)g/h) * NUM);
    }
    
    private Map<String, Integer> createMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        
        str = str.toUpperCase();

        for(int i=0; i<str.length()-1; i++) {
            if(!isAlpa(str.charAt(i)) || !isAlpa(str.charAt(i+1))) continue;
            
            String word = ""+str.charAt(i)+str.charAt(i+1);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        return map;
    }
    
    private boolean isAlpa(char c) {
        if(c < 'A' || c > 'Z') return false;
        return true;
    }
}
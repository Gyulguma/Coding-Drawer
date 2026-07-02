import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        if(words[0].length() < 2) return new int[]{1,1};
        char end = words[0].charAt(words[0].length() - 1);
        
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        int fail = 0;
        for(int i=1; i<words.length; i++) {
            if(words[i].length() < 2 || words[i].charAt(0) != end || set.contains(words[i])) {
                fail = i;
                break;
            }
            end = words[i].charAt(words[i].length()-1);
            set.add(words[i]);
        }
        
        if(fail != 0) {
            answer[0] = (fail%n) + 1;
            answer[1] = (fail/n) + 1;
        }
        return answer;
    }
}
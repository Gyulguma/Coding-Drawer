import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int num : win_nums) {
            set.add(num);
        }
        
        int count = 0;
        int min = 0;
        for(int num : lottos) {
            if(num == 0) {
                count++;
                continue;
            }
            if(set.contains(num)) min++;
        }
        
        answer[0] = (7-(min+count)) > 5 ? 6 : 7-(min+count);
        answer[1] = (7-min) > 5 ? 6 : 7-min;
        return answer;
    }
}
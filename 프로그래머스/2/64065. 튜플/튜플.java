import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] group = s.substring(1, s.length()-2).replaceAll("\\{", "").split("\\},");

        Arrays.sort(group, (o1, o2) -> o1.length() - o2.length());
        
        int[] answer = new int[group.length];
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<group.length; i++) {
            int[] numbers = Arrays.stream(group[i].split("\\,")).mapToInt(Integer::parseInt).toArray();
            for(int number : numbers) {
                if(set.contains(number)) continue;
                set.add(number);
                answer[i] = number;
                break;
            }
        }
        
        return answer;
    }
}
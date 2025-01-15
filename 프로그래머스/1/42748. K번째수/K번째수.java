import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        int index = 0;
        for(int[] command : commands){
            int[] newArray = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(newArray);
            answer[index++] = newArray[command[2]-1];
        }
        return answer;
    }
}
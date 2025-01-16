/*
0 1 3 5 6 7 9
*/

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int hIndex = 0;
        while(hIndex <= citations.length){
            for(int i=0; i<citations.length; i++){
                if(citations[i] < hIndex) continue;
                if(citations.length-i >= hIndex) {
                    answer = hIndex;
                    break;
                }
                return answer;
            }
            hIndex++;
        }
        return answer;
    }
}
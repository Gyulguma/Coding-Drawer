import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        Arrays.sort(stations);
        int around = w*2 + 1;
        int start = 1;
        for(int i=0; i<stations.length; i++) {
            int left = stations[i] - w;
            if(start < left) {
                answer += (left-start)%around == 0 ? (left-start)/around : (left-start)/around + 1;
            }
            start = stations[i] + w + 1;
        }
        
        if(start <= n) {
            answer += (n-start + 1)%around == 0 ? (n-start + 1)/around : (n-start + 1)/around + 1;
        }

        return answer;
    }
}
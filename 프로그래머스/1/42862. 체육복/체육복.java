import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n+2];
        for(int student : lost){
            arr[student]--;
        }
        
        for(int student : reserve){
            arr[student]++;
        }
        
        for(int i=1; i<=n; i++){
            if(arr[i] != -1) continue;
            if(arr[i-1] == 1){
                arr[i]++;
                arr[i-1]--;
                continue;
            }
            if(arr[i+1] == 1){
                arr[i]++;
                arr[i+1]--; 
            }
        }
        
        int fail = 0;
        for(int i=1; i<=n; i++){
            if(arr[i] == -1) fail++;
        }
        
        return n-fail;
    }
}
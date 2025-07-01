import java.util.*;

class Solution {
    String[][] park;
    
    public int solution(int[] mats, String[][] park) {
        this.park = park;
        int result = -1;
        Arrays.sort(mats);
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length; j++){
                if(!park[i][j].equals("-1")) continue;
                
                // if(i==0 && j==0) check(i, j);
                int size = check(i, j);
                // System.out.println(i+","+j+":"+size);
                int max = -1;
                for(int idx=0; idx<mats.length; idx++){
                    if(size < mats[idx]) break;
                    max = mats[idx];
                }
                if(max == -1) continue;
                result = Math.max(result, max);
            }
        }
        
        return result;
    }
    
    private int check(int x, int y){
        int garo = park[0].length-y;
        int sero = 0;
        while(garo > sero && x < park.length){
            int count = 0;
            for(int i=y; i<park[0].length; i++){
                if(!park[x][i].equals("-1")) break;
                count++;
            }
            // System.out.println(sero+","+count);
            garo = Math.min(garo, count);
            sero++;
            x++;
        }
        if(garo == 0) garo++;
        
        return Math.min(garo, sero);
    }
}
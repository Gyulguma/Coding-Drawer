import java.lang.Math;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] result = new int[friends.length][friends.length];
        int[] points = new int[friends.length];
        
        for(String gift : gifts){
            String[] names = gift.split(" ");
            int give = findName(friends, names[0]);
            int reseive = findName(friends, names[1]);
            result[give][reseive] += 1;
            points[give] += 1;
            points[reseive] -= 1;
        }
        
        int temp = 0;
        for(int i=0; i<friends.length; i++){
            for(int j=0; j<friends.length; j++){
                if(i==j) continue;
                if(result[i][j] > result[j][i]) temp++;
                else if(result[i][j] == result[j][i] && points[i] > points[j]) temp++;
            }
            answer = Math.max(answer, temp);
            temp = 0;
        }
        
        return answer;
    }
    
    private int findName(String[] friends, String name){
        for(int i=0; i<friends.length; i++)
            if(friends[i].equals(name)) return i;
        return 0;
    }
}
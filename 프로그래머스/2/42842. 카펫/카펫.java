/*
브라운 개수/2 + 2 == 가로 + 세로
ex. 24 -> 14
7, 7 ~ 13, 1

노란색의 개수 = (가로-2)x(세로-2)
ex. 8, 6 -> 6 * 4
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        int standard = brown/2 + 2;
        int a = (standard%2 == 0)? standard/2 : standard/2+1;
        int b = standard/2;
        
        while(b > 0){
            if((a-2) * (b-2) == yellow) return new int[]{a, b};
            a++; b--;
        }
        
        return new int[]{0,0};
    }
}
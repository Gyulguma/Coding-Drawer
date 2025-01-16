import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();
    private boolean[] visited;
    
    public int solution(String numbers) {
        //만들수 있는 숫자
        //소수인지 판별
        //소수이면 return+1
        visited = new boolean[numbers.length()];
        char[] charArr = numbers.toCharArray();
        recur(charArr, 0, "");
        
        for(int number : set) System.out.print(number+" ");
        return set.size();
    }
    
    private void recur(char[] numbers, int length, String current){
        if(length > numbers.length) {
            return;
        }
        if(length != 0 && isPrime(Integer.parseInt(current))) set.add(Integer.parseInt(current));
        
        for(int i=0; i<numbers.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            recur(numbers, length+1, current+numbers[i]);
            visited[i] = false;
        }
    }
    
    //소수인지 판별하는 함수
    private boolean isPrime(int number){
        if(number==1 || number <= 0) return false;
        if(number==2) return true;
        
        for(int i=2; i <= Math.sqrt(number); i++){
            if(number%i == 0) return false;
        }
        return true;
    }
    
}
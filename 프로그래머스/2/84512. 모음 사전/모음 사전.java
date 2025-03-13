import java.util.*;

class Solution {
    private List<String> list = new ArrayList<>();
    private String word = "AEIOU";
    
    public int solution(String target) {
        for(int i=1; i<=word.length(); i++){
            recur(i, 0, "");
        }
        
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            String temp = list.get(i);
            if(temp.equals(target))  return i+1;
        } 
        return 0;
    }
    
    
    
    private void recur(int max, int count, String current){
        if(count == max){
            list.add(current);
            return;
        }
        
        for(int i=0; i<word.length(); i++){
            recur(max, count+1, current+word.charAt(i));
        }
    }
}
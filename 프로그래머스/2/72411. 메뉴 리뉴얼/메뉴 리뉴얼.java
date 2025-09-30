import java.util.*;

class Solution {
    private Map<String, Integer> result = new HashMap<>();
    private int[] count = new int[11];
    private boolean[] visited;
    
    public String[] solution(String[] orders, int[] course) {
        Set<Integer> sizes = new HashSet<>();
        int end = 0;
        for (int c : course) {
            sizes.add(c);
            end = Math.max(end, c);
        }
        
        for(String order : orders) {
            char[] foods = order.toCharArray();
            Arrays.sort(foods);
            visited = new boolean[foods.length];
            // System.out.println(Arrays.toString(foods));
            addAll(foods, sizes, end, "", 0);
        }
        // System.out.println(Arrays.toString(count));
        List<String> list = new ArrayList<>();
        for(String food : result.keySet()) {
            int number = result.get(food);
            if(number < 2 || number < count[food.length()]) continue;
            list.add(food);
        }
        
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
    
    private void addAll(char[] foods, Set<Integer> sizes, int end, String current, int start) {
        // System.out.println(current+","+start);
        if(current.length() > end) return;
        if(current.length() >= 2 && sizes.contains(current.length())) {
            result.put(current, result.getOrDefault(current, 0)+1);
            count[current.length()] = Math.max(count[current.length()], result.get(current));
        }
        
        for(int i=start; i<foods.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            addAll(foods, sizes, end, current+foods[i], i+1);
            visited[i] = false;
        }
    }
}
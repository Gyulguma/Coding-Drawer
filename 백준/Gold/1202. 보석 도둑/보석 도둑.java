import java.util.*;
import java.io.*;

public class Main{
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Gem> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1.value, o2.value));
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
        	Gem gem = new Gem(m, v);
        	pq.offer(gem);
        }
        
        TreeMap<Integer, Integer> bags = new TreeMap<>();
        for(int i=0; i<k; i++) {
        	int weight = Integer.parseInt(br.readLine());
        	bags.put(weight, bags.getOrDefault(weight, 0) + 1);
        }
        
        long result = 0;
        while(!pq.isEmpty() && !bags.isEmpty()) {
        	Gem gem = pq.poll();
        	Integer bag = bags.ceilingKey(gem.weight);
        	if(bag == null) continue;
        	bags.put(bag, bags.get(bag) - 1);
        	if(bags.get(bag) == 0) bags.remove(bag);
        	result += gem.value;
        }
        
        System.out.println(result);
    }    
    
    private static class Gem {
    	int weight;
    	int value;
    	
    	public Gem(int weight, int value) {
    		this.weight = weight;
    		this.value = value;
    	}
    }
}
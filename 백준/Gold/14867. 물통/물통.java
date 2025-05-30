import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());
        int aGoal = Integer.parseInt(st.nextToken());
        int bGoal = Integer.parseInt(st.nextToken());
        
        Set<String> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0,0});
        set.add("0,0");
        
        while(!q.isEmpty()) {
        	int[] info = q.poll();
        	int a = info[0];
        	int b = info[1];
        	int count = info[2];
        	
        	if(a == aGoal && b == bGoal) {
        		System.out.println(count);
        		return;
        	}
        	
        	if(!set.contains(aSize+","+b) && a < aSize) {
        		q.offer(new int[] {aSize, b, count+1});
        		set.add(aSize+","+b);
        	}
        	if(!set.contains(a+","+bSize) && b < bSize) {
        		q.offer(new int[] {a, bSize, count+1});
        		set.add(a+","+bSize);
        	}
        	
        	int newA = 0;
        	int newB = 0;
        	if(a > 0) {
        		if(!set.contains("0,"+b)) {
        			q.offer(new int[] {0, b, count+1});
        			set.add("0,"+b);
        		}
        		
        		if(a <= bSize-b) {
        			newA = 0;
        			newB = b+a;
        		}else {
        			newA = a - (bSize-b);
        			newB = bSize;
        		}
        		if(!set.contains(newA+","+newB)) {
        			q.offer(new int[] {newA, newB, count+1});
        			set.add(newA+","+newB);
        		}
        	}
        	
        	newA = 0;
        	newB = 0;
        	if(b > 0) {
        		if(!set.contains(a+",0")) {
        			q.offer(new int[] {a, 0, count+1});
        			set.add(a+",0");
        		}
        		
        		if(b <= aSize-a) {
        			newB = 0;
        			newA = b+a;
        		}else {
        			newB = b - (aSize-a);
        			newA = aSize;
        		}
        		if(!set.contains(newA+","+newB)) {
        			q.offer(new int[] {newA, newB, count+1});
        			set.add(newA+","+newB);
        		}
        	}
        	
        }
        
        System.out.println(-1);
    }
}

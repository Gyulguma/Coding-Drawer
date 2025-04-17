import java.io.*;
import java.util.*;

public class Main {
	private static int n, m;
	private static int[] cost;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        cost = new int[m+1];
        long min = Integer.MAX_VALUE;
        for(int i=1; i<=m; i++) {
        	cost[i] = Integer.parseInt(st.nextToken());
        	min = Math.min(min, cost[i]);
        }
        
        if(n <= m) {
        	System.out.println(n);
        	return;
        }
        
        long left = 0;
        long right = n*min;
        long minTime = right;
        long result = 0;
        
        while(left <= right) {
        	long mid = left + (right-left)/2;
        	
        	long count = counting(mid);
        	if(count >= n) {
        		minTime = Math.min(minTime, mid);
        		right = mid-1;
        		continue;
        	}
        	left = mid+1;
        }
        
//        System.out.println(minTime);
        long count = 0;
        long time = minTime-1;
        //다음 사람이 타기 위해 기다려야 하는 시간
        long[] wait = new long[m+1];
		for(int i=1; i<=m; i++) {
			if(time/cost[i] == 0) count += 1;
			else if(time%cost[i] == 0) count += time/cost[i];
			else count += time/cost[i]+1;
			
			wait[i] = time%cost[i] == 0 ? 0 : cost[i] - time%cost[i];
		}
		
        long rest = n-count;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        	if(wait[o1] == wait[o2]) return Integer.compare(o1, o2);
        	return Long.compare(wait[o1], wait[o2]);
        });
        for(int i=1; i<=m; i++) {
        	pq.add(i);
        }
        
        for(int i=0; i<rest; i++) {
        	result = pq.poll();
        }
        System.out.println(result);
    }

	private static long counting(long time) {
		long count = 0;
		for(int i=1; i<=m; i++) {
			if(time/cost[i] == 0) count += 1;
			else if(time%cost[i] == 0) count += time/cost[i];
			else count += time/cost[i]+1;
		}
		
		return count;
	}
}

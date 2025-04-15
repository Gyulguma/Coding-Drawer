import java.io.*;
import java.util.*;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static long tree[];
	private static int treeSize;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        long[] num = new long[n+1];
        for(int i=1; i<=n; i++) {
        	num[i] = Long.parseLong(br.readLine());
        }
        
        int h = (int) Math.ceil(Math.log(n)/Math.log(2));
        treeSize = (int) Math.pow(2, h+1);
        
        tree = new long[treeSize];
        
        init(num, 1, 1, n);
        
        
        for(int i=0; i<m+k; i++) {
        	st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            if(a == 1) {
            	update(1, 1, n, b, c-num[b]);
            	num[b] = c;
            }
            else sb.append(sum(1, 1, n, b, (int) c)).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
    
    private static long init(long[] num, int node, int start, int end) {
    	if(start == end) {
    		return tree[node] = num[start];
    	}
    	
    	return tree[node] = init(num, node*2, start, (start+end)/2) + init(num, node*2+1, (start+end)/2+1, end);
    }

	private static void update(int node, int start, int end, int idx, long diff) {
		if(idx < start || end < idx) return;
		
		tree[node] += diff;
		
		if(start !=end) {
			update(node*2, start, (start+end)/2, idx, diff);
			update(node*2+1, (start+end)/2+1, end, idx, diff);
		}
	}

	private static long sum(int node, int start, int end, int left, int right) {
		if(left > end || right < start) return 0;
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right);
	}

}

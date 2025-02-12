import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] fruits = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		int left=0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int right=0; right<n; right++) {
			map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);
			
			while(map.size() > 2) {
				map.put(fruits[left], map.get(fruits[left])-1);
				if(map.get(fruits[left]) == 0) {
					map.remove(fruits[left]);
				}
				left++;
			}
			
			max = Math.max(max, right-left+1);
		}
		System.out.println(max);
	}
}
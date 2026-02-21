import java.io.*;
import java.util.*;

public class Main {
	private static int n, k;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		if(n==1 || n <= k) {
			System.out.println(0);
			return;
		}
		
		
		int[] sensors = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensors);
		
		List<int[]> list = new ArrayList<>();
		int pre = sensors[0];
		for(int i=1; i<n; i++) {
			if(pre == sensors[i]) continue;
			list.add(new int[] {pre, sensors[i]});
			pre = sensors[i];
		}
		
		Collections.sort(list, (o1, o2) -> (o2[1]-o2[0]) - (o1[1]-o1[0]));
		
		List<int[]> nonUseList = new ArrayList<>();
		for(int i=0; i<k-1; i++) {
			nonUseList.add(list.get(i));
		}
		
		Collections.sort(nonUseList, (o1, o2) -> o1[0] - o2[0]);
		
		int result = 0;
		int prePoint = sensors[0];
		for(int[] point : nonUseList) {
			result += point[0] - prePoint;
			prePoint = point[1];
		}
		result += sensors[n-1] - prePoint;
		
		System.out.println(result);
	}
}

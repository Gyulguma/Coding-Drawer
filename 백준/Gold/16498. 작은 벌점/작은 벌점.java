import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		
		int[] aNumbers = createSortedArray(a);
		int[] bNumbers = createSortedArray(b);
		int[] cNumbers = createSortedArray(c);
		
		int min = Math.min(a, Math.min(b, c));
		
		int result=0;
		if(min == a) result = getMin(aNumbers, bNumbers, cNumbers);
		else if(min == b) result = getMin(bNumbers, aNumbers, cNumbers);
		else result = getMin(cNumbers, aNumbers, bNumbers);
		
		System.out.println(result);
	}
	
	private static int getMin(int[] baseArray, int[] array1, int[] array2) {
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<baseArray.length; i++) {
			int num1 = baseArray[i];
			int[] num2s = findNearst(array1, num1);
			int[] num3s = findNearst(array2, num1);

			int score = 0;
			for(int num2 : num2s) {
				for(int num3 : num3s) {
					score = Math.abs(Math.max(num1, Math.max(num2, num3)) - Math.min(num1, Math.min(num2, num3)));
					min = Math.min(min, score);
				}
			}
		}
		
		return min;
	}

	private static int[] findNearst(int[] array, int target) {
		int left=0; int right=array.length-1; int mid = 0;
		while(left <= right) {
			if(mid == (left+right)/2) break;
			mid = (left+right)/2;
			
			if(array[mid] == target) {
				return new int[] {array[mid]};
			}
			if(array[mid] > target) {
				right = mid;
				continue;
			}
			left = mid;
		}
		return new int[] {array[left], array[right]};
	}

	private static int[] createSortedArray(int n) throws IOException{
		int[] array = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		return array;
	}
}

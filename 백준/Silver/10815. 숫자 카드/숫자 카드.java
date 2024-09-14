import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        int[] array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[m];
        int index = 0;
        for(int i=0; i<m; i++){
            if(contain(arr, array[i])) {
                result[i] = 1;
                index++;
            }
            if(index >= n) break;
        }
        for(int a : result) sb.append(a+" ");
        System.out.println(sb);
    }

    private static boolean contain(int[] arr, int target){
        int left=0, right=arr.length-1, mid=(left+right)/2;
        while(left <= right){
            mid=(left+right)/2;
            if(target == arr[mid]){
                return true;
            }
            if(target > arr[mid]){
                left = mid+1;
                continue;
            }
            if(target < arr[mid]){
                right = mid-1;
                continue;
            }
        }
        return false;
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] levels = new int[n];
        int minLevel = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
            minLevel = Math.min(minLevel, levels[i]);
        }
        
        int start = minLevel;
        int end = minLevel + k;
        int res = 0;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            long hap = 0;
            for (int level : levels) {
                if (mid > level) {
                    hap += (mid - level);
                }
            }
            
            if (hap <= k) {
                start = mid + 1;
                res = Math.max(mid, res);
            } else {
                end = mid - 1;
            }
        }
        
        System.out.println(res);
    }
}
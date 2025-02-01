import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			Set<Integer> set = new HashSet<>();
            int n = sc.nextInt();
            int number = n;
            while(set.size() != 10){
                int temp = number;
                while(temp>=10){
                    set.add(temp%10);
                    temp /= 10;
                }
               set.add(temp%10);
               number += n ;
            }
            number -= n;
			sb.append("#"+test_case+" "+number+"\n");
		}
        
        System.out.println(sb.toString().trim());
	}
}
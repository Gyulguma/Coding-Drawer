import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<repeat; i++){
            String word = br.readLine();
            int result = isPalindrome(word, 0, word.length()-1);
            sb.append(result).append(" ").append(count).append("\n");
            count = 0;
        }
        System.out.println(sb.toString().trim());
    }

    private static int isPalindrome(String s, int start, int end) {
        count++;
        if(start >= end) return 1;
        if(s.charAt(start) != s.charAt(end)) return 0;
        return isPalindrome(s, start + 1, end-1);
    }
}
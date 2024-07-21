import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] temp  = sc.nextLine().split(" ");
        int[] number = {Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2])};
        Arrays.sort(number);
        if(number[2] < number[0]+number[1]) System.out.println(number[0]+number[1]+number[2]);
        else System.out.println(2*(number[0]+number[1]) - 1);
    }
}
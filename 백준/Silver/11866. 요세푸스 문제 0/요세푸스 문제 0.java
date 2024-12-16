import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            linkedList.add(i);
        }

        List<Integer> list = new ArrayList<>();
        int index = 0;
        while(list.size() < n){
            index = (index + (k-1)) % linkedList.size();
            list.add(linkedList.get(index));
            linkedList.remove(index);
        }
        System.out.println(list.toString().replace("[", "<").replace("]", ">"));
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Member> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] target = br.readLine().split(" ");
            result.add(new Member(Integer.parseInt(target[0]), target[1], i));
        }

        Collections.sort(result, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.age > o2.age) return 1;
                if(o1.age < o2.age) return -1;
                if(o1.index > o2.index) return 1;
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Member a : result){
            sb.append(a.age+" "+a.name+"\n");
        }
        System.out.println(sb);
    }

    private static class Member{
        int age;
        String name;
        int index;
        public Member(int age, String name, int index){
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }
}
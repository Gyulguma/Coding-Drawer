import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(word.length() < M) continue;
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        List<Word> list = new ArrayList<>();
        for(String word : map.keySet()){
            int count = map.get(word);
            list.add(new Word(word, count));
        }
        Collections.sort(list, (o1, o2) -> {
            if(o1.count > o2.count) return -1;
            if(o1.count < o2.count) return 1;
            if(o1.word.length() > o2.word.length()) return -1;
            if(o1.word.length() < o2.word.length()) return 1;
            if(o1.word.compareTo(o2.word) < 0) return -1;
            return 1;
        });

        StringBuilder sb = new StringBuilder();
        for(Word word : list){
            sb.append(word.toString());
        }
        System.out.println(sb.toString().trim());
    }

    private static class Word{
        String word;
        int count;

        public Word(String word, int count){
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString(){
            return word+"\n";
        }
    }
}
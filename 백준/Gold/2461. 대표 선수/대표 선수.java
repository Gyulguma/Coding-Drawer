import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Student[] students = new Student[n*m];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		students[(i*m) + j] = new Student(i+1, Integer.parseInt(st.nextToken()));
        	}
        }
        
        Arrays.sort(students);

        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        
        while(end < n*m) {
        	Student current = students[end];
        	
        	map.put(current.room, map.getOrDefault(current.room, 0)+1);
        	
        	while(map.size() == n) {
        		min = Math.min(min, students[end].score - students[start].score);
        		
        		Student startStudent = students[start];
        		int count = map.get(startStudent.room) - 1;
        		if(count == 0) map.remove(startStudent.room);
        		else map.put(startStudent.room, count);
        		
        		start++;
        	}
        	end++;
        }

        System.out.println(min);
    }
    
    private static class Student implements Comparable<Student>{
    	private int room;
    	private int score;
    	
    	public Student(int room, int score) {
    		this.room = room;
    		this.score = score;
    	}
    	
    	@Override
    	public int compareTo(Student s) {
    		return Integer.compare(this.score, s.score);
    	}
    	
    	@Override
    	public String toString() {
    		return "("+this.room+","+this.score+")";
    	}
    }
}

import java.io.*;
import java.util.*;

public class Main {
	private static final int[][] dd = {{7,15}, {3,11}, {1,9}, {5,13}};
	private static BufferedReader br;
	private static int n,m;
	private static MyLinkedList list; 
	
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        initial();
        
        for(int repeat=0; repeat<m; repeat++) {
        	destroy();//구슬 파괴
        	checkBead();//구슬 폭파 (수정하기)
        	changeBaed();//구슬 변화
        }
        
        System.out.println(list.score());
    }

	private static void initial() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        list = new MyLinkedList();
        int x = n/2, y = n/2;
        int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
        int dir = 0;
        int count = 1;
        To: while(true) {
        	
        	for(int i=0; i<count; i++) {
        		x += dirs[dir][0];
        		y += dirs[dir][1];
        		if(x<0 || x>=n || y<0 || y>=n || map[x][y] == 0) break To;
        		list.add(map[x][y]);
        	}
        	
        	dir = (dir+1)%4;
        	for(int i=0; i<count; i++) {
        		x += dirs[dir][0];
        		y += dirs[dir][1];
        		if(x<0 || x>=n || y<0 || y>=n || map[x][y] == 0) break To;
        		list.add(map[x][y]);
        	}
        	dir = (dir+1)%4;
        	count++;
        }
	}
	
	private static void destroy() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken())-1;
		int s = Integer.parseInt(st.nextToken());
		
		int[] info = dd[d];
		int target = info[0];
		
		list.remove(target);
		target--;
		
		for(int i=0; i<s-1; i++) {
			target += info[1] + 8*i;
			list.remove(target);
			target--;
		}
	}

	private static void checkBead() {
		int removeCount = list.removeContinuousElements();
		while(removeCount > 0) {
//			list.print();
			removeCount = list.removeContinuousElements();
		}
	}

	private static void changeBaed() {
		list.changeBead();
	}

	private static class Node{
    	private int value;
    	private Node pre;
    	private Node next;
    	
    	public Node(int value) {
    		this.value = value;
    	}
    }
    
    private static class MyLinkedList{
    	private int size;
    	private Node head;
    	private Node tail;
    	private int[] destroyCount;
    	
    	public MyLinkedList() {
    		this.size = 0;
    		this.head = null;
    		this.tail = null;
    		this.destroyCount = new int[3];
    	}
    	
    	public int score() {
			int result = 0;
			for(int i=0; i<3; i++) {
				result += (i+1)*destroyCount[i];
			}
			return result;
		}

		public void changeBead() {
    		Node node = head;
    		if(node == null) return;
    		
    		Node start = head;
    		int preValue = node.value;
    		int count = 0;
    		int point = 1;
    		while(node != null) {
//    			if(point > (n*n)-1) break;
    			
    			if(node.value == preValue) {
    				count++;
    				node = node.next;
    				continue;
    			}
    			Node first = new Node(count);
    			Node second = new Node(preValue);
    			first.next = second;
    			second.pre = first;
    			
    			if(start == head) {
    				head = first;
    				head.pre = null;
    			}
    			else{
    				start.pre.next = first;
    				first.pre = start.pre;
    			}
    			size += 2-count;
    			second.next = node;
    			node.pre = second;
    			count = 1;
    			preValue = node.value;
    			start = node;
    			node = node.next;
    		}
    		Node first = new Node(count);
			Node second = new Node(preValue);
			first.next = second;
			second.pre = first;
			
			if(start == head) {
				head = first;
				head.pre = null;
			}
			else{
				start.pre.next = first;
				first.pre = start.pre;
			}
			size += 2-count;
			tail = second;
			tail.next = null;
			
    		if(size > (n*n)-1) {
    			for(int i=0; i<size-((n*n)-1); i++) {
    				tail = tail.pre;
    			}
    			tail.next = null;
    			size = (n*n)-1;
    			return;
    		}
    		
		}

		public int removeContinuousElements() {
			Node node = head;
			Node start = head;
			int preValue = 0;
			int count = 1;
			int removeCount = 0;
			
			while(node != null) {
				if(node.value == preValue) {
					count++;
				}
				else {
					if(count >= 4) {
						if(start == head) {
							head = node;
							head.pre = null;
						}
						else {
							start.pre.next = node;
							node.pre = start.pre;
						}
						size -= count;
						destroyCount[preValue-1] += count;
						removeCount += count;
					}
					start = node;
					preValue = node.value;
					count = 1;
				}
				node = node.next;
			}
			if(count >= 4) {
				if(start == head) {
					head = node;
				}
				else {
					start.pre.next = null;
					tail = start.pre;
					tail.next = null;
				}
				size -= count;
				destroyCount[preValue-1] += count;
				removeCount += count;
			}
			
			return removeCount;
		}

		public void remove(int target) {
			if(target > size) return;
    		if(target == 1) {
    			head = head.next;
    			head.pre = null;
    			size--;
    			return;
    		}
    		
    		if(target == size) {
    			tail = tail.pre;
    			tail.next = null;
    			size--;
    			return;
    		}
    		
    		Node node = head;
    		for(int i=1; i<target; i++) {
    			node = node.next;
    		}
    		node.pre.next = node.next;
    		node.next.pre = node.pre;
    		size--;
		}

		public void add(int value) {
    		Node node = new Node(value);
    		if(head == null) {
    			head = node;
    			tail = node;
    			size++;
    		}else {
    			tail.next = node;
    			node.pre = tail;
    			tail = node;
    			size++;
    		}
    	}
		
		public void print() {
			Node node = head;
			while(node != null) {
				System.out.print(node.value);
				node = node.next;
			}
			System.out.println();
		}
    }
}

package programers.heap;

import java.util.PriorityQueue;

public class l42628 {
	public static void main(String[] args) {
//		String[] operations = {"I 16","D 1"};
//		String[] operations = {"I 7","I 5","I -5","D -1"};
//		String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
		String[] operations = {"I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1", "I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1"};
//		String[] operations = {"I 1"};
//		String[] operations = {"I 1", "I -1", "D 1", "I 2", "D -1"};
		print(solution2(operations));
	}
	/*
	 * operation.length = (minHeap.size+maxHeap.size)가 틀린조건인데 못찾아서 오래걸렸다. 
	 * 나는 수학적인 방법으로 풀었지만 remove메소드를 사용하는게 더 쉬운 풀이가 되었을 것 같다.
	 * */
	public static int[] solution(String[] operations) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2)->o1-o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2)->o2-o1);
		int cnt = 0;
		for(String s : operations) {
			if(s.startsWith("I")) {
				cnt ++;
				minHeap.offer(Integer.parseInt(s.split(" ")[1]));
				maxHeap.offer(Integer.parseInt(s.split(" ")[1]));
			}
			else if(s.equals("D 1")) {
				maxHeap.poll();
			}
			else if(s.equals("D -1")) {
				minHeap.poll();
			}
			if(	minHeap.isEmpty()||
				maxHeap.isEmpty()||
				(s.startsWith("D")&&cnt==(minHeap.size()+maxHeap.size()))) {
				minHeap.clear();
				maxHeap.clear();
			}
		}
		int[] answer = {maxHeap.peek()==null?0:maxHeap.peek(), minHeap.peek()==null?0:minHeap.peek()};
        return answer;
    }
	/*이중우선순위큐에서 remove 하는 경우 null 체크를 잘해줘야 한다.*/
	public static int[] solution2(String[] operations) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2)->o1-o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2)->o2-o1);
		for(String s : operations) {
			if(s.startsWith("I")) {
				minHeap.offer(Integer.parseInt(s.split(" ")[1]));
				maxHeap.offer(Integer.parseInt(s.split(" ")[1]));
			}
			else if(s.equals("D 1")) {
				if(maxHeap.peek()!=null)minHeap.remove(maxHeap.poll());
			}
			else if(s.equals("D -1")) {
				if(minHeap.peek()!=null)maxHeap.remove(minHeap.poll());
			}
		}
		int[] answer = {maxHeap.peek()==null?0:maxHeap.peek(), minHeap.peek()==null?0:minHeap.peek()};
        return answer;
    }
	public static void print(int[] arr) {
		for(int i: arr)System.out.print(i+" ");
	}
}
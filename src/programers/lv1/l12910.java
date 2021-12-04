package programers.lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class l12910 {
	public static void main(String[] args) {
//		int[] arr= {5, 9, 7, 10}; int divisor=5;
		int[] arr= {2, 36, 1, 3}; int divisor=1;
//		int[] arr= {3,2,6}; int divisor=10;
		new l12910().print(new l12910().solution2(arr, divisor));
	}
	public int[] solution(int[] arr, int divisor) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int num : arr) {
			if(num%divisor==0)pq.add(num);
		}
		if(pq.size()==0)return new int[] {-1};
        int[] answer = new int[pq.size()];
        int idx=0;
        while(!pq.isEmpty()) {
        	answer[idx++]=pq.poll();
        }
        return answer;
    }
	public int[] solution2(int[] arr, int divisor) {
		int[] answer= Arrays.stream(arr).filter(i->i%divisor==0).sorted().toArray();
		if(answer.length == 0) answer = new int[] {-1};
        return answer;
	}
	public void print(int[] arr) {
		for(int i : arr)System.out.print(i+" ");
		System.out.println();
	}
}
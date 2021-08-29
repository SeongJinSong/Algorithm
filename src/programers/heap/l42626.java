package programers.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class l42626 {
	public static void main(String[] args) {
		int [] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
//		Arrays.sort(scoville, 2, 5);
//		print(scoville);
		System.out.println(solution3(scoville, K));
	}
	/* Heap 을 사용 안한 첫 풀이 */
	/* 배열에 컴포넌트를 삭제하지 않고 진행해봤는데 에러를 찾는게 너무 어렵다*/
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        for(int i=0;i<scoville.length;i++) {
        	Arrays.sort(scoville, i, scoville.length-1);
        	if(scoville[i]>=K)return answer;
        	if(i==scoville.length-1)return -1;
        	int mix = scoville[i]+2*scoville[i+1];
        	scoville[i+1] = mix;
        	answer++;
        }
        return answer;
    }
	/* 성능테스트에서 막힌다 */
	public static int solution2(int[] scoville, int K) {
		int answer = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i : scoville)arr.add(i);
		while(arr.size()>1) {
			Collections.sort(arr);
			if(arr.get(0)>=K) return answer;
			int mix = arr.get(0)+2*arr.get(1);
			arr.remove(0);
			arr.remove(0);
			arr.add(mix);
			answer++;
		}
		if(arr.get(0)<K) return -1;
		return answer;
	}
	/* priorityqueue를 사용해야 성능통과 가능 */
	public static int solution3(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i : scoville)pq.add(i);
		while(pq.size()>1) {
			if(pq.peek()>=K) return answer;
			pq.add(pq.poll()+2*pq.poll());
			answer++;
		}
		if(pq.peek()<K) return -1;
		return answer;
	}
}

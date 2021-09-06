package programers.queue_stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class l42584 {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3, 1};
		print(solution(prices));
	}
	public static int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i:prices) q.add(i);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	int dur = 0;
        	for(int i=prices.length-q.size();i<prices.length;i++) {
        		if(cur<=prices[i]) {
        			dur++;
        		}
        		else {
        			dur++;
        			break;
        		}
        	}
        	arr.add(dur);
        }
        return arr.stream().mapToInt(i->i).toArray();
    }
	public static void print(int[] arr) {
		for(int i : arr)System.out.print(i+" ");
	}
	/* 이중 for문으로 더 간단하게 풀 수 있음 */
	public static int[] solution2(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}

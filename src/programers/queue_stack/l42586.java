package programers.queue_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class l42586 {
	public static void main(String[] args) {
		int [] progresses = {93, 30, 55};
		int [] speed = {1, 30, 5};
		
		int [] ans = solution2(progresses, speed);
		System.out.println();
		print(ans);
	}
	
	public static void print(int[] ans) {
		for(int i=0;i<ans.length;i++) {
			System.out.print("["+i+"]:"+ans[i]+" ");
		}
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
        Stack<Integer> pstk = new Stack<Integer>();
        Stack<Integer> sstk = new Stack<Integer>();
        /* 오랜만에 해서 스택을 거꾸로 넣음 ㅜㅜ */
        for(int i=progresses.length-1;i>=0;i--) {
        	pstk.push(progresses[i]);
        	sstk.push(speeds[i]);
        }
        
        int popElemCount=0;
        while(!pstk.isEmpty()) {
        	while(pstk.peek() < 100){
        		for(int i=0;i<pstk.size();i++) {
        			pstk.setElementAt(pstk.get(i)+sstk.get(i), i);
        		}
        		if(popElemCount!=0) {
        			arr.add(popElemCount);
        			popElemCount=0;
        		}
        	};
        	pstk.pop();
        	popElemCount++;
        }
        if(popElemCount!=0)arr.add(popElemCount);
        
        int[] answer = new int[arr.size()];
        for(int i=0;i<answer.length;i++) {
        	answer[i]=arr.get(i);
        }
        return answer;
    }
	
	/* bottom up 방식의 짧은 풀이 */
	public static int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = 0;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}

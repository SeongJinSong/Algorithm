package programers.queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class l42583 {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
	//그냥 억지부려봄 이런건 다음부터 클래스를 활용해서 깔금하게 코딩하자
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> right = new LinkedList<Integer>();
        Queue<Integer> bridge = new LinkedList<Integer>();
        Queue<Integer> time = new LinkedList<Integer>();
        for(int i:truck_weights)right.add(i);
        int answer = 0;
        int total_weight=0;
        
        while(!right.isEmpty()) {
        	if(!time.isEmpty()&&answer-bridge_length>=time.peek()) {
        		total_weight-=bridge.poll();
        		time.poll();
        	}
        	if(weight >= total_weight+right.peek()) {
        		int tmp = right.poll();
        		total_weight+=tmp;
        		bridge.add(tmp);
        		time.add(answer);
        	}
        	answer++;
        }
        answer+=bridge_length;
        return answer;
    }
}

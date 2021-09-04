package programers.queue_stack;

import java.util.ArrayList;

public class l42587 {
	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		System.out.println(solution(priorities, location));
	}
	public static int solution(int[] priorities, int location) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        for(int i=0;i<priorities.length;i++){
        	queue.add(priorities[i]);
        }
        int answer = 0;
        loop : while(location!=-1) {
        	for(int i=1;i<queue.size();i++)
        	{
        		if(queue.get(0)<queue.get(i)) {
        			int cur = queue.remove(0);
        			queue.add(cur);
        			if(location==0) {
        				location=queue.size()-1;
        			}else location--;
        			continue loop;
        		}
        	}
        	queue.remove(0);
        	answer++;
        	location-=1;
        }
        
        return answer;
    }
}

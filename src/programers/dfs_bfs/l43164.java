package programers.dfs_bfs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class l43164 {
	public static void main(String[] args) {
//		String[][] tickets1= {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//		String[][] tickets2= {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//		String[][] tickets3= {{"ICN","AAA"},{"ICN","AAA"},{"ICN","AAA"},{"AAA","ICN"},{"AAA","ICN"}};
//		String[][] tickets4= {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
		String[][] tickets5= {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{"CCC", "ICN"}};
		
		l43164 ll = new l43164();
//		ll.print(ll.solution(tickets1));
//		System.out.println();
//		ll.print(ll.solution(tickets2));
//		System.out.println();
//		ll.print(ll.solution(tickets3));
//		System.out.println();
//		ll.print(ll.solution(tickets4));
//		System.out.println();
		ll.print(ll.solution(tickets5));
	}
	class AirPort{
		private String name;
		private Integer idx;
		public AirPort(String name, Integer idx) {
			this.name=name;
			this.idx=idx;
		}
	}
	public String[] solution(String[][] tickets) {
        boolean[] visit = new boolean[tickets.length];
        PriorityQueue<AirPort> pq = new PriorityQueue<AirPort>((a,b)->a.name.compareTo(b.name));
        ArrayList<String> route = new ArrayList<String>();
        pq.add(new AirPort("ICN", -1));
        while(!pq.isEmpty()&&isNext(visit)) {
        	AirPort s = pq.poll();
        	pq.clear();
        	route.add(s.name);
        	if(s.idx>=0) visit[s.idx]=true;
        	for(int i=0;i<tickets.length;i++) {
        		if(visit[i])continue;
        		if(s.name.equals(tickets[i][0])) {
        			pq.add(new AirPort(tickets[i][1], i));
        		}
        		else if(s.name.equals(tickets[i][1])) {
        			pq.add(new AirPort(tickets[i][0], i));
        		}
        	}
        }
        return route.stream().toArray(String[]::new);
    }
	public boolean isNext(boolean[] visit) {
		for(boolean b : visit) {
			if(!b)return true;
		}
		return false;
	}
	public void print(String[] arr) {
        for(String s : arr)System.out.print(s+" ");
    }
}

package programers.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class l43164 {
	public static void main(String[] args) {
//		String[][] tickets1= {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//		String[][] tickets2= {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[][] tickets3= {{"ICN","AAA"},{"ICN","AAA"},{"ICN","AAA"},{"AAA","ICN"},{"AAA","ICN"}};
//		String[][] tickets4= {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
//		String[][] tickets5= {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{"CCC", "ICN"}};
		
		//1번 테스트 케이스
		String[][] tickets6 = {{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}};
		
		l43164 ll = new l43164();
//		ll.print(ll.solution(tickets1));
//		System.out.println();
//		ll.print(ll.solution(tickets2));
//		System.out.println();
		//ll.print(ll.solution(tickets3));
//		System.out.println();
//		ll.print(ll.solution(tickets4));
//		System.out.println();
//		ll.print(ll.solution(tickets5));
		System.out.println();
		ll.print(ll.solution2(tickets6));
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
        /* 중복된 값을 PQ에 넣는 경우 PQ는 오작동한다.
         * pq.poll을 실행하는 경우 나머지 남은 것들에 대해서 재정렬하지 않는다. 
         * https://www.python2.net/questions-279467.htm
         * 정렬을 위한 자료구조를 ArrayList로 변경
         
         * */
        ArrayList<AirPort> sortNext = new ArrayList<AirPort>();
        Stack<AirPort> route = new Stack<AirPort>();
        Stack<AirPort> next = new Stack<AirPort>();
        boolean[] visit = new boolean[tickets.length];
        route.add(new AirPort("ICN", null));
        int loop=0;
        while(route.size()<=tickets.length&&loop++<20) {
        	AirPort cur = route.peek();
        	if(cur.idx!=null) {
        		visit[cur.idx]=true;
        	}
        	for(int i=0;i<tickets.length;i++) {
        		if(visit[i])continue;
        		if(cur.name.equals(tickets[i][0])) {
        			sortNext.add(new AirPort(tickets[i][1], i));
        		}
        	}
        	//아래 형태의 풀이방법으로는 1개는 가능하지만 depth가 깊어진 후에 갈길이 없는 경우 rollback하기 너무 어렵다
        	if(sortNext.size()==0) {
        		System.out.print("sortNext size 0 :");
        		print(getCurRoute(route));
        		System.out.println();
        		visit[route.pop().idx]=false;
        	}
        	else {
        		Collections.sort(sortNext, (a,b)->b.name.compareTo(a.name));
        		for(AirPort a : sortNext)next.add(a);
        	}
        	if(next.size()>0) {
        		System.out.print("# "); print(getCurRoute(route));
        		System.out.println();
        		System.out.println("    next :"+next.peek().name);
        		route.add(next.pop());
        	}
        	else{
        		System.out.print("## ");
        		print(getCurRoute(route));
        		System.out.println();
        		visit[route.pop().idx]=false;
        	};
        	sortNext.clear();
        }
        String[] answer = new String[route.size()];
        for(int i=0;i<route.size();i++) {
        	answer[i]=route.get(i).name;
        }
        return answer;
    }
	/* 경로를 String으로 이어붙인 후 나중에 파싱해서 배열로 생성*/
	boolean[] visited;
	ArrayList<String> routes;
	public String[] solution2(String[][] tickets) {
		visited = new boolean[tickets.length];
		routes = new ArrayList<String>();
		dfs(0, "ICN", "ICN", tickets);
		Collections.sort(routes);
		return routes.get(0).split(" ");
	}
	public void dfs(int cnt, String cur, String route, String[][] tickets) {
		if(cnt == tickets.length) {
			routes.add(route);
			return;
		}
		for(int i=0; i<tickets.length; i++) {
			if(!visited[i]&&tickets[i][0].equals(cur)) {
				visited[i]=true;
				dfs(cnt+1, tickets[i][1], route+" "+tickets[i][1], tickets);
				/*메모리 공간 낭비를 줄이기 위한 테크닉*/
				visited[i]=false;
			}
		}
		return;
	}
	public String[] getCurRoute(Stack<AirPort> route) {
		String[] answer = new String[route.size()];
        for(int i=0;i<route.size();i++) {
        	answer[i]=route.get(i).name;
        }
        return answer;
	}
	public void print(String[] arr) {
        for(String s : arr)System.out.print(s+" ");
    }
}

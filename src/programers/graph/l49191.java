package programers.graph;

import java.util.LinkedList;
import java.util.List;

public class l49191 {
	public static void main(String[] args) {
		int n=5; int[][] results= {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(n, results));
		
		
	}
	/* 양방향 탐색
	 * - 순위를 확정 지을 수 있는 것은 결국 자신 이외의 사람들과 승패가 갈려야 한다.
	 * - a-b에서 b가 승자고 b-c에서 c가 승자면 a-c에서 승자는 a가 된다.
	 * - 모든 선수들을 연결하여 그래프 탐색을 하면 위의 경우를 파악할 수 있다.
	 * */
	static boolean[] visited;
	static List<Integer>[] order;
	static List<Integer>[] reverse;
	static int count;
	public static int solution(int n, int[][] results) {
		int answer = 0;
		order = new LinkedList[n];
		reverse = new LinkedList[n];
		
		for(int i=0;i<order.length;i++) {
			order[i] = new LinkedList<Integer>();
			reverse[i] = new LinkedList<Integer>();
		}
		for(int i=0; i<results.length;i++) {
			int win = results[i][0] -1;
			int lose = results[i][1]-1;
			order[lose].add(win);
			reverse[win].add(lose);
		}
		for(int i=0;i<n;i++) {
			int sum = 0;
			count = 0;
			visited = new boolean[n];
			explore(i, order);
			sum = count;
			count = 0;
			visited = new boolean[n];
			explore(i, reverse);
			sum+= count;
			if(sum == n-1)answer++;
		}
		return answer;
    }
	private static void explore(int v, List<Integer>[] graph) {
		visited[v] = true;
		for(int adj : graph[v]) {
			if(!visited[adj]) {
				count++;
				explore(adj, graph);
			}
		}
	}
	/* 플루이드 와샬
	 * - 이 알고리즘은 O(N^3) 이므로 범위에 따라 조심히 사용해야 한다.*/
	public static int solution2(int n, int[][] results) {
		int answer = 0;
		int [][] map = new int[n][n];
		for(int i=0;i<results.length;i++) {
			int win = results[i][0]-1;
			int lose = results[i][1]-1;
			map[win][lose] = 1;
			map[lose][win] = -1;
		}
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==j || map[i][j]!=0) continue;
					if(map[i][k] == map[k][j])map[i][j]=map[i][k];
				}
			}
		}
		loop: for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==0 && i!=j)continue loop;
			}
			answer++;
		}
		return answer; 
	}
}

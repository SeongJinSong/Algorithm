package programers.greedy;

import java.util.Arrays;

public class l42861 {
	public static void main(String[] args) {
//		int n=4; int[][] costs= {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
//		int n = 6; int[][] costs = {{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10},{1,2,2},{2,5,3},{4,5,4}};
		int n = 5; int[][] costs = {{0,1,1},{0,4,5},{2,4,1},{2,3,1},{3,4,1}};
		System.out.println(solution(n, costs));
	}
	/*순환하고 있다는 표시를 하는 쉬운 방법을 알았다.*/
	static int[] parent;
	public static int solution(int n, int[][] costs) {
		Arrays.sort(costs, (a, b) -> a[2] - b[2]);
		parent=new int[n];
		for(int i=0;i<parent.length;i++)parent[i]=i;
		int answer = 0;
		for (int i = 0; i < costs.length; i++) {
			if(find(costs[i][0])==find(costs[i][1])) {
				continue;	
			}
			else {
				union(costs[i][0], costs[i][1]);
				answer += costs[i][2];
			}	
		}
		return answer;
	}
	// 정점의 부모를 찾아준다.
	public static int find(int child) {
		if(parent[child]==child) return child;
		return parent[child] = find(parent[child]);
	}
	//정점의 부모를 변경시킴으로써 서로 연결되어있다는 것을 표시해준다.
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA!=rootB)parent[rootB]=rootA;
	}
}

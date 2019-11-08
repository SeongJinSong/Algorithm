package basic.graph;

import java.util.*;

class Edge implements Comparable<Edge>{
	int from, to;
	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}
	@Override
	public int compareTo(Edge edge) {
		if(this.from < edge.from) {
			return -1;
		}else if(this.from == edge.from) {
			if(this.to < edge.to) {
				return -1;
			}else if(this.to == edge.to) {
				return 0;
			}else
				return 1;
		}else
			return 1;
	}
}
public class BFS_DFS2 {
	static Edge[] edge;
	static int[] cnt;
	static boolean[] check;
 	static void dfs(int node) {
		if(check[node]) {
			return;
		}
		check[node] = true;
		System.out.print(node + " ");
		for(int i = cnt[node-1]; i < cnt[node]; i++) {
			if(!check[edge[i].to]) {
				dfs(edge[i].to);
			}
		}
	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = true;
		while(!q.isEmpty()) {
			int p = q.remove();
			check[p] = true;
			System.out.print(p + " ");
			for(int i = cnt[p-1]; i < cnt[p]; i++) {
				if(check[edge[i].to] == false) {
					q.add(edge[i].to);
					check[edge[i].to] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		
		edge = new Edge[2*m];
		cnt = new int[n+1];
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			edge[i] = new Edge(x, y);
			edge[m+i] = new Edge(y, x);
		}
		Arrays.sort(edge);
		
		for(int i = 1; i< n + 1; i++) {
			for(int j = 0; j < 2*m; j++) {
				if(edge[j].from == i)
					cnt[i] += 1;
			}
		}
		for(int i = 1; i < n + 1; i++) {
			cnt[i] += cnt[i-1];
		}
		
		check = new boolean[n+1];
		dfs(start);
		System.out.println();
		
		check = new boolean[n+1];
		bfs(start);
		System.out.println();
	}
}

package basic.graph;

import java.util.*;

public class BFS_DFS1 {
	public static boolean c[];
	public static ArrayList<Integer> v[];
	public static int m;
	public static int n;
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;
		System.out.print(x + " ");
		for(int y : v[x]) {
			if(c[y] == false)
				dfs(y);
		}
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		c[start] = true;
		while(!q.isEmpty()) {
			int p = q.remove();
			System.out.print(p + " ");
			for(int y : v[p]) {
				if(c[y] == false) {
					q.add(y);
					c[y] = true;
				}
					
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int start = sc.nextInt();
		
		v = (ArrayList<Integer>[])new ArrayList[n+1];
		
		for(int i = 0; i < n + 1; i++) {
			v[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i < m + 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			v[x].add(y);
			v[y].add(x);
		}
		for(int i = 1; i < n + 1; i++)
			Collections.sort(v[i]);
		
		c = new boolean[n+1];
		dfs(start);
		System.out.println();
		
		c = new boolean[n+1];
		bfs(start);
		System.out.println();
	}
}

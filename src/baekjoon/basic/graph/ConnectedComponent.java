package baekjoon.basic.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponent {
	static boolean c[];
	static ArrayList<Integer>[] a;
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;
		for(int i=0; i<a[x].size();i++) {
			int next = a[x].get(i);
			if(!c[next]) {
				dfs(next);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		a = (ArrayList<Integer>[])new ArrayList[n+1];
		for(int i=1;i<n+1;i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i < m+1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		/*for(int i=1; i<n+1; i++) {
			Collections.sort(a[i]);
		}// 작은노드 우선 같은 조건이 없었으므로 사실 할 필요가 없다.*/		
		int ans=0;
		c = new boolean[n+1];
		for(int i=1; i<n+1; i++) {
			if(!c[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
}

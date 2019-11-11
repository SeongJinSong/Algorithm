package basic.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Bipartite_Graph {
	public static ArrayList<Integer> a[];
	public static int c[];
	public static void dfs(int x, int t) {
		if(c[x] != 0) {
			return;
		}
		c[x] = t;
		for(int y : a[x]) {
			if(c[y] == 0) {
				dfs(y, 3-t);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-->0) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			a= (ArrayList<Integer>[])new ArrayList[v+1];
			c = new int[v+1];
			
			for(int i=1; i<v+1;i++) {
				a[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<e; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				a[x].add(y);
				a[y].add(x);
			}
			
			for(int i=1; i<=v; i++) {
				if(c[i] == 0) {
					dfs(i, 1);
				}
			}
			boolean ans = true;
			for(int j=1; j<=v; j++) {
				for(int y : a[j]) {
					if(c[j] == c[y])
						ans = false;
				}
			}
			
			if(ans)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}

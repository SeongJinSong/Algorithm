package basic.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Bipartite_Graph {
	public static ArrayList<Integer> a[];
	public static boolean c[];
	public static ArrayList<Integer> p;
	public static ArrayList<Integer> q;
	public static ArrayList<String> ans;
	public static boolean t = false;
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;
		if(!t)
			p.add(x);
		else
			q.add(x);
		t = !t;
		for(int i=0; i<a[x].size(); i++) {
			int next = a[x].get(i);
			if(!c[next]) {
				dfs(next);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		ans = new ArrayList<String>();
		while(k-->0) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			a= (ArrayList<Integer>[])new ArrayList[v+1];
			
			for(int i=1; i<v+1;i++) {
				a[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<e; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				a[x].add(y);
				a[y].add(x);
			}
			boolean res = false;
			for(int i=1; i<v+1; i++) {
				c = new boolean[v+1];
				p = new ArrayList<Integer>();
				q = new ArrayList<Integer>();
				t = false;
				dfs(i);
				if(res = check(p, q)) {
					break;
				};
			}
			if(res)ans.add("YES");
			else ans.add("NO");
		}
		for(String r : ans) {
			System.out.println(r);
		}
	}
	public static boolean check(ArrayList<Integer> p, ArrayList<Integer> q) {
		for(int i=0;i<p.size();i++) {
			for(int j=i+1; j<p.size(); j++) {
				if(a[p.get(i)].contains(p.get(j)))return false;
			}
		}
		for(int i=0;i<q.size();i++) {
			for(int j=i+1; j<q.size(); j++) {
				if(a[q.get(i)].contains(q.get(j)))return false;
			}
		}
		return true;
	}
}

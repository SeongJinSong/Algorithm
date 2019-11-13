package basic.graph.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Stat{
	int x, s;
	public Stat(int x, int s) {
		this.x = x;
		this.s = s;
	}
}
public class HideAndSeek {
	static int setNx(int x, int i) {
		if(i==0) return x+1;
		else if(i==1) return x-1;
		else if(i==2) return 2*x;
		else return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		if(n==k) {
			System.out.println(0);
			return;
		}
		Queue<Stat> q = new LinkedList<Stat>();
		int []c = new int[100001];
		q.add(new Stat(n, 0));
		c[n]=1;
		while(!q.isEmpty()) {
			Stat st = q.remove();
			for(int i=0;i<3;i++) {
				int nx = setNx(st.x, i);
				int ns = st.s+1;
				if(nx < 0 || nx > 100000 ||c[nx]==1) {
					continue;
				}
				if(nx == k) {
					System.out.println(ns);
					return;
				}
				c[nx]=1;
				q.add(new Stat(nx, ns));
			}
		}
	}
}

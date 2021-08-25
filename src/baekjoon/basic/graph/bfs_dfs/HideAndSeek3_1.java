package baekjoon.basic.graph.bfs_dfs;

import java.util.*;
public class HideAndSeek3_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int c[] = new int[100001];
		
		Queue<Integer> q0 = new LinkedList<Integer>();
		Queue<Integer> q1 = new LinkedList<Integer>();
		
		q0.add(n);
		c[n]=1;
		
		while(!q0.isEmpty()&&c[k]==0) {
			int p = q0.remove();
			if(p!=0&&2*p<=100000&&c[2*p]==0) {
				c[2*p]=c[p];
				q0.add(2*p);
			}
			for(int np : new int[]{p-1, p+1}) {
				if(np>=0&&np<=100000&&c[np]==0) {
					c[np]=c[p]+1;
					q1.add(np);
				}
			}
			if(q0.isEmpty()) {
				q0 = q1;
				q1 = new LinkedList<Integer>();
			}
		}
		System.out.println(c[k]-1);
		sc.close();
	}
}

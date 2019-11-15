package basic.graph.bfs_dfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class HideAndSeek3_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] c = new int[100001];
		Deque<Integer> q = new LinkedList<Integer>();
		q.add(n);
		c[n] = 1;
		while(!q.isEmpty()) {
			int p = q.remove();
			if(p!=0&&2*p<=100000&&c[2*p]==0) {
				c[2*p]=c[p];
				q.addFirst(2*p);
			}
			for(int np : new int[]{p-1, p+1}) {
				if(np>=0&&np<=100000&&c[np]==0) {
					c[np]=c[p]+1;
					q.addLast(np);
				}
			}
		}
		System.out.println(c[k]-1);
		sc.close();
	}
}

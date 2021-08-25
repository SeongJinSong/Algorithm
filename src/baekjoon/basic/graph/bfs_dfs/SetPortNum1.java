package baekjoon.basic.graph.bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SetPortNum1 {
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	static int a[][];
	static int c[][];
	static int n;
	static void bfs(int x, int y, int s) {
		c[x][y] = s;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x,y));
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx<0||nx>=n||ny<0||ny>=n) {
					continue;
				}
				if(c[nx][ny] == 0 && a[nx][ny]==1) {
					c[nx][ny] = s;
					q.add(new Pair(nx, ny));
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		a = new int[n][n];
		c = new int[n][n];
		for(int i=0;i<n;i++) {
			String line = sc.nextLine();
			for(int j=0;j<line.length();j++	) {
				a[i][j] = line.charAt(j)-'0';
			}
		}
		int k=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(c[i][j] == 0 & a[i][j]==1) {
					bfs(i,j,k++);
				}
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i=0;i<k-1;i++) {
			ans.add(0);
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(c[i][j]!=0) {
					ans.set(c[i][j]-1, ans.get(c[i][j]-1)+1);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(k-1);
		for(int y : ans) {
			System.out.println(y);
		}
	}
}

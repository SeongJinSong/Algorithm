package baekjoon.basic.graph.bfs_dfs;

import java.util.*;

public class AlgoSpot2 {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = { 0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[][];
		int c[][];
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		a = new int[n+1][m+1];
		c = new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			String line = sc.nextLine();
			for(int j=0;j<line.length();j++) {
				a[i][j+1]=line.charAt(j)-'0';
			}
		}
		Deque<Algo> q = new LinkedList<Algo>();
		c[1][1]=1;
		q.addFirst(new Algo(1, 1));
		while(!q.isEmpty()&&c[n][m]==0) {
			Algo p = q.remove();
			for(int i=0;i<4;i++) {
				int ny = p.y+dy[i];
				int nx = p.x+dx[i];
				if(ny<1||nx<1||ny>n||nx>m)continue;
				if(a[ny][nx]==0&&c[ny][nx]==0) {
					c[ny][nx] = c[p.y][p.x];
					q.addFirst(new Algo(ny, nx));
				}
				else if(a[ny][nx]==1&&c[ny][nx]==0) {
					c[ny][nx] = c[p.y][p.x]+1;
					q.addLast(new Algo(ny,nx));
				}
			}
		}
		System.out.println(c[n][m]-1);
	}
}

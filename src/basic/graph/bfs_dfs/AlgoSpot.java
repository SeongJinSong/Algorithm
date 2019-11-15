package basic.graph.bfs_dfs;

import java.util.*;

class Algo{
	int y, x;
	public Algo(int y, int x) {
		this.y=y;
		this.x=x;
	}
}
public class AlgoSpot {
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
		Queue<Algo> q0 = new LinkedList<Algo>();
		Queue<Algo> q1 = new LinkedList<Algo>();
		c[1][1]=1;
		q0.add(new Algo(1, 1));
		while(!q0.isEmpty()&&c[n][m]==0) {
			Algo p = q0.remove();
			for(int i=0;i<4;i++) {
				int ny = p.y+dy[i];
				int nx = p.x+dx[i];
				if(ny<1||nx<1||ny>n||nx>m)continue;
				if(a[ny][nx]==0&&c[ny][nx]==0) {
					c[ny][nx] = c[p.y][p.x];
					q0.add(new Algo(ny, nx));
				}
				else if(a[ny][nx]==1&&c[ny][nx]==0) {
					c[ny][nx] = c[p.y][p.x] + 1;
					q1.add(new Algo(ny,nx));
				}
			}
			if(q0.isEmpty()) {
				q0 = q1;
				q1 = new LinkedList<Algo>();
			}
		}
		System.out.println(c[n][m]-1);
	}
}

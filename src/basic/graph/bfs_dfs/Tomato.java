package basic.graph.bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Triple{
	int y, x, s;
	public Triple(int y, int x, int s) {
		this.y = y;
		this.x = x;
		this.s = s;
	}
}
public class Tomato {
	static int n;
	static int m;
	static int a[][];
	static int c[][];
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = { 0, 0, -1, 1};
	static ArrayList<Triple> start;;
	static void bfs(ArrayList<Triple> start){
		Queue<Triple> q = new LinkedList<Triple>();
		for(Triple t : start) {
			q.add(t);
			c[t.y][t.x]=1;
		}
		while(!q.isEmpty()) {
			Triple p = q.remove();
			for(int i=0;i<4;i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				int ns = p.s+1;
				if(ny<0||nx<0||ny>=n||nx>=m)
					continue;
				if(a[ny][nx]==0&&c[ny][nx]==0) {
					c[ny][nx] = ns;
					q.add(new Triple(ny, nx, ns));
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		a = new int[n][m];
		c = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j]==-1)c[i][j]=-1;
			}
		}
		start = new ArrayList<Triple>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j]==1&&c[i][j]==0) {
					start.add(new Triple(i, j, 1));
				}
			}
		}
		bfs(start);
		int max=0;
		boolean fail = false;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(max <= c[i][j]) {
					max = c[i][j];
				}
				if(c[i][j]==0) {
					fail = true;
				}
			}
		}
		if(fail)System.out.println(-1);
		else System.out.println(max-1);
	}
}

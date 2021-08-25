package baekjoon.basic.graph.bfs_dfs;

import java.util.*;

class Crash{
	int y, x, c;
	public Crash(int y, int x, int c){
		this.y = y;
		this.x = x;
		this.c = c;
	}
}
public class CrashWall {
	static int[] dy = {-1, 1,  0, 0};
	static int[] dx = { 0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[][];
		int c[][][];
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new int[n][m];
		c = new int[n][m][2];
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String line = sc.nextLine();
			for(int j=0;j<m;j++) {
				a[i][j] = line.charAt(j)-'0';
			}
		}
		
		Queue<Crash> q = new LinkedList<Crash>();
		c[0][0][0] = 1;
		q.add(new Crash(0, 0, 0));
		while(!q.isEmpty()) {
			Crash p = q.remove();
			
			for(int i=0;i<4;i++) {
				int ny = p.y+dy[i];
				int nx = p.x+dx[i];
				int nc = p.c;
				if(nx<0||ny<0||ny>=n||nx>=m) continue;
				if(a[ny][nx] == 1) nc+=1;
				if(nc>=2)continue;
				if(c[ny][nx][nc]==0) {
					c[ny][nx][nc] = c[p.y][p.x][p.c]+1;
					q.add(new Crash(ny, nx, nc));
				}
			}
		}
		if(c[n-1][m-1][0] != 0&&c[n-1][m-1][1] != 0){
			System.out.println(Math.min(c[n-1][m-1][0], c[n-1][m-1][1]));
		}
		else if(c[n-1][m-1][0] != 0) {
			System.out.println(c[n-1][m-1][0]);
		}
		else if(c[n-1][m-1][1] != 0) {
			System.out.println(c[n-1][m-1][1]);
		}
		else {
			System.out.println(-1);
		}
	}
}

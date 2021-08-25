package baekjoon.basic.graph.bfs_dfs;

import java.util.*;
class Esc{
	int y, x;
	public Esc(int y, int x) {
		this.y=y;
		this.x=x;
	}
}
public class Escape {
	static int[] dy = {-1, 1,  0, 0};
	static int[] dx = { 0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.nextLine();
		char a[][] = new char[r][c];
		int chk[][] = new int[r][c];
		int water[][] = new int[r][c];
		for(int i=0;i<r;i++) {
			String line = sc.nextLine();
			for(int j=0;j<c;j++) {
				a[i][j]=line.charAt(j);
			}
		}
		Queue<Esc> q = new LinkedList<Esc>();
		int ey =-1, ex =-1;
		int sy =-1, sx =-1;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(a[i][j]=='*') {
					water[i][j]=1;
					q.add(new Esc(i,j));
				}
				if(a[i][j]=='S') {
					sy=i;
					sx=j;
				}
				if(a[i][j]=='D') {
					ey=i;
					ex=j;
				}
			}
		}
		while(!q.isEmpty()) {
			Esc p = q.remove();
			for(int i=0;i<4;i++) {
				int ny = p.y+dy[i];
				int nx = p.x+dx[i];
				if(ny<0||nx<0||ny>=r||nx>=c)continue;
				if(a[ny][nx]=='.'&&water[ny][nx]==0) {
					water[ny][nx]=water[p.y][p.x]+1;
					q.add(new Esc(ny,nx));
				}
			}
		}
		q = new LinkedList<Esc>();
		chk[sy][sx]=1;
		q.add(new Esc(sy, sx));
		while(!q.isEmpty()) {
			Esc p = q.remove();
			for(int i=0;i<4;i++) {
				int ny = p.y+dy[i];
				int nx = p.x+dx[i];
				if(ny<0||nx<0||ny>=r||nx>=c)continue;
				if(chk[ny][nx]!=0)continue;
				if(a[ny][nx]=='X')continue;
				if(water[ny][nx]<=chk[p.y][p.x]+1&&water[ny][nx]!=0)continue;
				
				chk[ny][nx] = chk[p.y][p.x]+1;
				q.add(new Esc(ny ,nx));
			}
		}
//		print(water, r, c);
//		print(chk, r, c);
		if(chk[ey][ex]==0) {
			System.out.println("KAKTUS");
		}
		else {
			System.out.println(chk[ey][ex]-1);
		}
		
	}
	static void print(int[][] chk, int r, int c) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(chk[i][j]+"\t");
			}
			System.out.println();
		}
	}
}

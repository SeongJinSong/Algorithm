package basic.graph.bfs_dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class CountIsland {
	public static int a[][];
	public static int c[][];
	public static int[] dx = {-1,  0,  1, 1, 1, 0, -1, -1};
	public static int[] dy = {-1, -1, -1, 0, 1, 1,  1,  0};
	public static int w;
	public static int h;
	static void dfs(int y, int x, int s) {
		if(c[y][x] != 0 && a[y][x] !=1) {
			return;
		}
		c[y][x] = s;
		for(int i = 0; i<8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx < 0 || ny < 0 || ny >= h || nx >= w) {
				continue;
			}
			if(c[ny][nx] == 0 && a[ny][nx] == 1) {
				dfs(ny, nx, s);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if(w==0&&h==0) {
				break;
			}
			a = new int[h][w];
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++){
					a[i][j] = sc.nextInt();
				}
			}
			c = new int[h][w];
			int k = 1;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(c[i][j] == 0 && a[i][j] == 1) {
						dfs(i, j, k++);
					}
				}
			}
			System.out.println(k-1);
		}
	}
}

package basic.graph.bfs_dfs;

import java.util.Scanner;

public class Tomato {
	static int a[][];
	static int c[][];
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = { 0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new int[n][m];
		c = new int[n][m];
		for(int i=n;i<n;i++) {
			for(int j=m;j<m;j++) {
				a[n][m] = sc.nextInt();
			}
		}
	}
}

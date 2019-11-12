package basic.graph.bfs_dfs;

import java.util.Scanner;

public class SearchMaze {
	static int a[][];
	static boolean c[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		a = new int[n][m];
		c = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String line = sc.nextLine();
			for(int j=0;j<line.length();j++) {
				a[i][j] = line.charAt(j)-'0';
			}
		}
	}
}
